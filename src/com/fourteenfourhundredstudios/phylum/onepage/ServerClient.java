package com.fourteenfourhundredstudios.phylum.onepage;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fourteenfourhundredstudios.phylum.onepage.pages.ErrorPage;
import com.fourteenfourhundredstudios.phylum.onepage.pages.ResultPage;


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
                String line="";

                while((line = in.readLine()) != null){
                	if(line.equals(""))break;
                	if(line.startsWith("GET")){
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
                		    	urlParams.put(getRequest.substring(getRequest.indexOf("?")+1,getRequest.indexOf("=")), getRequest.substring(getRequest.indexOf("=")+1,getRequest.length()).replace("+"," "));
                		    }
                		    getRequest=getRequest.substring(0,getRequest.indexOf("?"));
                		}
                		String extension=getRequest.substring(getRequest.indexOf(".")+1);
                		switch(extension){
                			//when the server wants a file with an extension (EX: "http://phylum.us/index.html")
                			case "html":
                				serverPage = new HTMLPage(getRequest,me.getOutputStream(),urlParams);
                				break;
                			case "jpg":
                				serverPage = new ImagePage(getRequest,me.getOutputStream(),urlParams,extension);
                				break;
                			default:
                				switch(getRequest.toLowerCase().substring(1)){
                					//all pages that don't have a file extension (EX: "http://phylum.us/search")
                					case "search":
                						serverPage = new HTMLPage("/search.html",me.getOutputStream(),urlParams);
                						break;
                					case "result":
                						serverPage = new ResultPage(getRequest,me.getOutputStream(),urlParams);
                						break;
                					case "":
                						//if no extension return index page
                						serverPage = new HTMLPage("/index.html",me.getOutputStream(),urlParams);
                						break;
                					default:
                						serverPage = new ErrorPage(getRequest,me.getOutputStream(),urlParams);
                						System.out.println("put error page here: "+getRequest);
                				}
                		}
                		serverPage.sendResponse();
                	}
                }

                in.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
     
	
}
