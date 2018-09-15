package server;
import java.io.*;
import java.net.*;

import queue.LinkedQueue;
/**
 * Declaración de la clase Server, maneja toda la lógica del juego Dots
 * @author Daniel Sing
 *
 */
public class Server {
	//Atributos de la clase server
	private ServerSocket server;
	private LinkedQueue<Socket> queue;
	
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