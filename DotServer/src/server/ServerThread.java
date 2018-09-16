package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.json.simple.JSONObject;

import encode.MatrixToJson;
import linkedlist.LinkedList;
import matrix.Matrix;
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
    public static int i;
    
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
    public void send() {
    	MatrixToJson mtoj = new MatrixToJson();
    	JSONObject obj = mtoj.fetchJsonFile("test.json");
    	Matrix m = mtoj.decodeMatrix(obj);
    	
    	//Esta lista es para que funque, de momento no s� que ir�a
    	LinkedList l = new LinkedList();
    	
    	//Aqu� se hace la l�gica sobre la matriz.
    	
    	
    	
    	
    	/*
    	 * JSONObject obj = new JSONObject();
        obj.put("X", "numero en X");
        obj.put("Y", "numero en Y");  
    	 */
    	// con eso si sirve Xd
    	
    	
    	JSONObject obj2 = mtoj.encondeMatrix(m,l);
    	
         try (FileWriter file = new FileWriter("test.json")) {

                file.write(obj2.toJSONString());
                file.flush();

          } catch (IOException e) {
                e.printStackTrace();
            }
         
         
        try {
        	//Aqu� hay que modificar esto para que la condicion de imprimir el objeto json no sea escribir en la consola.
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("Server: " + obj);
 
           // socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void received() throws IOException {
		BufferedReader brs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		try{
			String time = brs.readLine();
			System.out.println(time);
		} 
		catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} 
		catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		}
	}
 
	public void eleccion() throws IOException { //metodo prueba
		System.out.println("1: enviar, 2: recibir");
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		this.eleccion1();
		if(i==1) {
			this.send();
		}else {
			this.received();
		}
	}

	public void eleccion1() throws IOException { //metodo prueba
		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		PrintStream ps = new PrintStream(socket.getOutputStream());

		ps.println(i);
	}
}