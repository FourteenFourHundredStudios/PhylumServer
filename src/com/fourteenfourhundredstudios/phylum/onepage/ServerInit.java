package com.fourteenfourhundredstudios.phylum.onepage;

import java.net.InetAddress;
import java.net.ServerSocket;

import com.fourteenfourhundredstudios.phylum.questions.NPLHandler;

public class ServerInit {
	   
    public ServerInit(){
    	ServerSocket s = null;
        try {
        	System.out.println("NPLHandler loading...");
        	NPLHandler.load();
        	try{
        		s = new ServerSocket(80,5,InetAddress.getByName("10.0.0.19"));
        	}catch(Exception e){
        		System.out.println("Could not bind to Phylum.us, binding to localhost");
        		s = new ServerSocket(3005,5,InetAddress.getByName("localhost"));
        	}
            System.out.println("Phylum server started!");
            while(true){
                ServerClient user = new ServerClient(s.accept());
                System.out.println("User Connected ");
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String args[]){
        new ServerInit();
    }
     
}
