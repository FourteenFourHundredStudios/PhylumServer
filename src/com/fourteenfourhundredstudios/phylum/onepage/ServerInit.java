package com.fourteenfourhundredstudios.phylum.onepage;

import java.net.InetAddress;
import java.net.ServerSocket;

import com.fourteenfourhundredstudios.phylum.questions.NPLHandler;

public class ServerInit {
	   
    public ServerInit(){
    	ServerSocket s;
        try {
        	NPLHandler.load();
            s = new ServerSocket(80,5,InetAddress.getByName("10.0.0.19"));
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
