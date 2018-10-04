package server;
import java.io.*;
import java.net.*;
import queue.LinkedQueue;
/**
 * Server Class.
 * @author Daniel Sing
 *
 */
public class Server {
	//Attributes of the class server.
	private ServerSocket server;
	private static Server sv;
	// Indicates if there's a game in progress.
	private boolean flagGame = false;
	 
	/**
	 * Receives as the IP where it'll be running as parameter.
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
			System.out.println("Cannot create more than one server instance");
		}
		return sv;
	}
	
	/**
	 * Listens to the requests from the clients.
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
            			if(clients.getSize()==2 && flagGame == false) {
            				System.out.println("Game Start");//Aquí se llamaría un método que cambie la pantalla de registro a la del juego en sí
            				clients.first().received();
            				clients.dequeue();
            				clients.first().received(); 
            				clients.dequeue();
            				
            				flagGame = true;
            				//Y cuando el juego termine se cambia el flag nuevamente a falso
            			}
            		}else {
            			clients.enqueue(st);
            			System.out.println("Max number of players reached");
            			System.out.println("Cliente en lista de espera");
            		}
            		
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
	}

	public int getPort() {
		return this.server.getLocalPort();
	}
	
	/**
	 * Server socket address getter.
	 */
	public InetAddress getSocketAddress() {
		return this.server.getInetAddress();
	}

	/**
	 * Initializes server
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server app = getSingletonInstance("127.0.0.1");
		app.listen();
	  }
}