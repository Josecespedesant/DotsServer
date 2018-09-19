package server;
import java.io.*;
import java.net.*;
import queue.LinkedQueue;
/**
 * Declaration of the class Server.
 * @author Daniel Sing
 *
 */
public class Server {
	//Attributes of the class server.
	private ServerSocket server;
	private static Server sv;
	//Esta bandera permitir� saber cu�ndo hay un juego en progreso y cu�ndo no.
	private boolean flagGame = false;
	 
	/**
	 * Constructor of the class Server that receives as the IP where it'll be running as parameter.
	 * @param ipAddress
	 * @throws Exception
	 */
	private Server(String ipAddress) throws Exception{
		if(ipAddress != null && !ipAddress.isEmpty()) {
			this.server = new ServerSocket(4444,1,InetAddress.getByName(ipAddress));	
		}else {
			this.server = new ServerSocket(0,1,InetAddress.getLocalHost());	
		}
	}
	
	/**
	 * Singleton pattern used to create just one instance of the server.
	 * @param ipAddress
	 * @return
	 * @throws Exception
	 */
	public static Server getSingletonInstance(String ipAddress) throws Exception {
		if(sv == null) {
			sv = new Server(ipAddress);
		}
		else {
			System.out.println("No se puede crear m�s de una instancia del servidor");
		}
		return sv;
	}
	
	/**
	 * Method that'll be listening to the requests from the clients.
	 * @throws Exception
	 */ 
	private void listen() throws Exception{
            try{
            	System.out.println("Server is listening on port " + getPort());
            	LinkedQueue<ServerThread> clients = new LinkedQueue<ServerThread>();
            	
            	while (true) {
            		Socket socket = server.accept();
            		ServerThread st = new ServerThread(socket);      		
            		if(clients.getSize()<2) {
            			clients.enqueue(st);
            			System.out.println(clients.getSize());
            			System.out.println("New client connected");
            			st.eleccion();
            			if(clients.getSize()==2 && flagGame == false) {
            				System.out.println("Comienza el juego");//Aqu� se llamar�a un m�todo que cambie la pantalla de registro a la del juego en s�
            				clients.dequeue();
            				clients.dequeue();
            				flagGame = true;
            				//Y cuando el juego termine se cambia el flag nuevamente a falso
            			}
            		}else {
            			clients.enqueue(st);
            			System.out.println("N�mero m�ximo de jugadores alcanzado");
            			System.out.println("Cliente en lista de espera");
            		}
            		
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
	}
	
	/**
	 * Devuelve el puerto al que est� anclado el servidor
	 * @return Un entero que corresponde al n�mero del puerto.
	 */
	public int getPort() {
		return this.server.getLocalPort();
	}
	
	/**
	 * Devuelve la direcci�n de sockets del servidor.
	 * @return La direcci�n del socket.
	 */
	public InetAddress getSocketAddress() {
		return this.server.getInetAddress();
	}

/**
 * M�todo main que corre el servidor.
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception {
  	Server app = getSingletonInstance("127.0.0.1");
  	app.listen();
  }
}