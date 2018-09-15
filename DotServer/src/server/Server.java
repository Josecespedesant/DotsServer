package server;
import java.io.*;
import java.net.*;

import queue.LinkedQueue;
/**
 * Declaraci�n de la clase Server, maneja toda la l�gica del juego Dots
 * @author Daniel Sing
 *
 */
public class Server {
	//Atributos de la clase server
	private ServerSocket server;
	private LinkedQueue<Socket> queue;
	
	/**
	 * Constructor de la clase Server que recibe como par�metro la ip en donde se estar� ejecutando.
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
	 * M�todo que estar� escuchando las solicitudes de los clientes.
	 * @throws Exception
	 */
	private void listen() throws Exception{
            try{
            	System.out.println("Server is listening on port " + getPort());
            	while (true) {
            		Socket socket = server.accept();
            		System.out.println("New client connected");
            		new ServerThread(socket).start();    		
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
    //  if (args.length < 1) return;
  	Server app = new Server("192.168.100.2");
  	app.listen();
  }
}