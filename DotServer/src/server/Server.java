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
	//Esta bandera permitirá saber cuándo hay un juego en progreso y cuándo no.
	private boolean flagGame = false;
	
	/**
	 * Constructor of the class Server that receives as the IP where it'll be running as parameter.
	 * @param ipAddress
	 * @throws Exception
	 */
	public Server(String ipAddress) throws Exception{
		if(ipAddress != null && !ipAddress.isEmpty()) {
			this.server = new ServerSocket(4444,1,InetAddress.getByName(ipAddress));	
		}else {
			this.server = new ServerSocket(0,1,InetAddress.getLocalHost());	
		}
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
            			st.start();
            			if(clients.getSize()==2) {
            				System.out.println("Comienza el juego");
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
    //  if (args.length < 1) return;
  	Server app = new Server("192.168.100.2");
  	app.listen();
  }
}