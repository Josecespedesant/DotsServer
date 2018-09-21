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
	//Esta bandera permitirá saber cuándo hay un juego en progreso y cuándo no.
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
			System.out.println("No se puede crear más de una instancia del servidor");
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
            				System.out.println("Comienza el juego");//Aquí se llamaría un método que cambie la pantalla de registro a la del juego en sí
            				clients.dequeue();
            				clients.dequeue();
            				flagGame = true;
            				//Y cuando el juego termine se cambia el flag nuevamente a falso
            			}
            		}else {
            			clients.enqueue(st);
            			System.out.println("Número máximo de jugadores alcanzado");
            			System.out.println("Cliente en lista de espera");
            		}
            		
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
	}
	
	/**
	 * Devuelve el puerto al que está anclado el servidor
	 * @return Un entero que corresponde al número del puerto.
	 */
	public int getPort() {
		return this.server.getLocalPort();
	}
	
	/**
	 * Devuelve la dirección de sockets del servidor.
	 * @return La dirección del socket.
	 */
	public InetAddress getSocketAddress() {
		return this.server.getInetAddress();
	}

/**
 * Método main que corre el servidor.
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception {
  	Server app = getSingletonInstance("127.0.0.1");
  	app.listen();
  }
}