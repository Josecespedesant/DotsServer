package server;

import java.io.*;
import java.net.*;

import org.json.simple.JSONObject;
 
/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
    private Socket socket;
 
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
 
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