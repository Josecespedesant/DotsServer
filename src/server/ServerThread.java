package server;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import json_conversion.Conversion;
import json_parse.Parse;
import linkedlist.LinkedList;
import logic.Logic;
import logic.Player;
import matrix.Matrix;
import queue.LinkedQueue;
 
/** 
 * This thread is responsible to handle client connection.
 * @author www.codejava.net
 */

public class ServerThread extends Thread {
 //Attribute of the class ServerThread
    private Socket socket;
    private LinkedQueue<Socket> queue;
    public static int i;
    public Logic logic;
    public static int w;
    public int clients = 0;
    public String nombre1;
    public String nombre2;
    
    
    /**
     * Constructor of the ServerThread class that receives the socket.
     * @param socket
     */
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    
    
    @SuppressWarnings("unchecked")
    public void send(JSONObject newJson) throws IOException {
     
     JSONObject obj = newJson;
     try(OutputStreamWriter out = new OutputStreamWriter(this.socket.getOutputStream(), StandardCharsets.UTF_8)){
         out.write(obj.toJSONString());
     }
     
    }
    
    
    public void receivedNames() throws ParseException, IOException {
    	BufferedReader brs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	try {
    		String JsonString = brs.readLine();
    		JSONParser parser1 = new JSONParser();
    		JSONObject jsonConNombre = (JSONObject) parser1.parse(JsonString);

    		Conversion conv = new Conversion();
    		conv.saveJsonFile(jsonConNombre, "name.json");
    		//JSONObject jsonConNombre = (JSONObject) parser1.parse(new InputStreamReader(new FileInputStream("name.json")));

    		Parse parser2 = new Parse();
 
    		
    		System.out.println(parser2.jsonToName(jsonConNombre));
    		
    		if(clients == 0) {
    			nombre1 = parser2.jsonToName(jsonConNombre);
    			clients++;
    		}else if(clients == 1) {
    			nombre2 = parser2.jsonToName(jsonConNombre); 
    			JSONObject nombres = parser2.playerNamesasJson(nombre1, nombre2);
    			this.send(nombres);
    			clients = 0;
    		}
    	}catch (UnknownHostException ex) {
    		System.out.println("Server not found: " + ex.getMessage());
    	} 
    	catch (IOException ex) {
    		System.out.println("I/O error: " + ex.getMessage());
    	}
    }
    
    public void received() throws IOException, ParseException {
    	BufferedReader brs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	try{
    		String JsonString = brs.readLine();
    		JSONParser parserS = new JSONParser();
    		JSONObject json = (JSONObject) parserS.parse(new InputStreamReader(new FileInputStream("gameState.json")));
    		System.out.println(JsonString);
   
    		Parse parserM = new Parse();
    		LinkedList list = parserM.JsonToGameState(json);
    		
    		
    		Player player1 = (Player) list.getHead().getNext().getData();
    		Player player2 = (Player) list.getHead().getNext().getNext().getData();
    		Matrix matrix = (Matrix) list.getHead().getData();
    		
    		logic = new Logic(player1, player2, matrix);
    		
    		LinkedList pos = (LinkedList) list.getHead().getNext().getNext().getNext().getData();
    		logic.modifyMatrix(pos, 1); 
    		
    		JSONObject newJson = parserM.gameStateToJson(matrix, player1, player2, pos);
    		Conversion conv = new Conversion();
    		conv.saveJsonFile(newJson, "gameState.json");
    		
    		
    		matrix.printMatrix();
    		
    		this.send(newJson);
    	} 
    	catch (UnknownHostException ex) {
    		System.out.println("Server not found: " + ex.getMessage());
    	} 
    	catch (IOException ex) {
    		System.out.println("I/O error: " + ex.getMessage());
    	}
    	
    }

   }