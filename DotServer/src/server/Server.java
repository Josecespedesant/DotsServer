package server;
import java.io.*;
import java.net.*;
import queue.LinkedQueue;

import java.util.LinkedList;
/**
 * Declaración de la clase Server, maneja toda la lógica del juego Dots
 * @author Daniel Sing
 *
 */
public class Server {
	//Atributos de la clase server
	private ServerSocket server;
	private LinkedQueue<Socket> clients;
	
	/**
	 * Constructor de la clase Server que recibe como parámetro la ip en donde se estará ejecutando.
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
	 * Método que estará escuchando las solicitudes de los clientes.
	 * @throws Exception
	 */
	private void listen() throws Exception{
            try{
            	System.out.println("Server is listening on port " + getPort());
            	LinkedList<ServerThread> cola = new LinkedList(); //biblioteca prohibida por el Dios de la progra TOñO GONZALEZ
            	while (true) {
            		Socket socket = server.accept();
        			ServerThread st = new ServerThread(socket);
            		
            		if(cola.size()<2) { 
                		cola.offer(st); // añade un elemento a la cola
            			System.out.println(cola.size());
                		System.out.println("New client connected");
                		st.start();
                		
            		}else { //si la cola tiene mas de dos elementos manda ese manesaje 
                		cola.offer(st); // añade un elemento a la cola
            			System.out.println("Numero maximo de jugadores alcanzado");
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
  	Server app = new Server("127.0.0.1");
  	app.listen();
  	
  }
}