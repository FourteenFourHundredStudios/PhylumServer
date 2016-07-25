package com.fourteenfourhundredstudios.phylum.onepage;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ServerClient {

	 
    Socket me;
    HashMap<String,String> urlParams=new HashMap<String,String>();
    String root="FileSystem/";
    BufferedReader in;
	BufferedReader br;
	OutputStreamWriter osw;
	
    public ServerClient(Socket me){
        this.me=me;
        action ac = new action();
        ac.start();

    }
     

    class action extends Thread{
        public void run(){
            try{

                in = new BufferedReader(new InputStreamReader(me.getInputStream()));
               // osw = new OutputStreamWriter(me.getOutputStream());
                String line="";

                while((line = in.readLine()) != null){
                	if(line.equals(""))break;
                	if(line.startsWith("GET")){
                	//	send(get(line.split(" ")[1]));
                		String getRequest=line.split(" ")[1];
                		
                		ServerPage serverPage=null;
                		//parse URL params
                		 if(getRequest.indexOf("?")>-1){
                		    if(getRequest.indexOf("&")>-1){
                		    	String[] part = getRequest.substring(getRequest.indexOf("?")+1).split("&");
                		    	for(String s:part){
                		    		urlParams.put(s.split("=")[0],s.split("=")[1]);
                		    	}
                		    }else{
                		    	urlParams.put(getRequest.substring(getRequest.indexOf("?")+1,getRequest.indexOf("=")), getRequest.substring(getRequest.indexOf("=")+1,getRequest.length()));
                		    }
                		    getRequest=getRequest.substring(0,getRequest.indexOf("?"));
                		}
                		String extension=getRequest.substring(getRequest.indexOf(".")+1);
                		switch(extension){
                			case "html":
                				serverPage = new HTMLPage(getRequest,me.getOutputStream(),urlParams);
                				break;
                			case "jpg":
                				serverPage = new ImagePage(getRequest,me.getOutputStream(),urlParams,extension);
                				break;
                			default:
                				System.out.println("no extension");
                		}
                		serverPage.sendResponse();
                	}
                }
              //  System.out.println("\n");
                in.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
     
	
}
