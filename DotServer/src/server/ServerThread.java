package server;

import java.io.*;
import java.net.*;
import org.json.simple.JSONObject;

import queue.LinkedQueue;
 
/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
	//Attribute of the class ServerThread
    private Socket socket;
    private LinkedQueue<Socket> queue;
    
    /**
     * Constructor of the ServerThread class that receives the socket.
     * @param socket
     */
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Keep the server running.
     */
    @SuppressWarnings("unchecked")
	public void run() {
    	
    	JSONObject obj = new JSONObject();
        obj.put("X", "numero en X");
        obj.put("Y", "numero en Y");

         try (FileWriter file = new FileWriter("test.json")) {

                file.write(obj.toJSONString());
                file.flush();

          } catch (IOException e) {
                e.printStackTrace();
            }
        try {
        	//Aquí hay que modificar esto para que la condicion de imprimir el objeto json no sea escribir en la consola.
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            String st;
            do {
                st = reader.readLine();
                ps.println("Server: " + obj);
 
            } while (true);
 
           // socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}