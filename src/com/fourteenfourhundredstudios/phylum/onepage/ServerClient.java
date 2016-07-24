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
    Map<String,String> urlParams=new HashMap<String,String>();
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
                osw = new OutputStreamWriter(me.getOutputStream());
                String line="";

                while((line = in.readLine()) != null){
                	if(line.equals(""))break;
                	if(line.startsWith("GET")){
                		send(get(line.split(" ")[1]));
                	}
                }
                System.out.println("\n");
                in.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
     
    public void printArray(String[] arr){
        for (String i:arr){
            System.out.println(i);
        }
    }
    
    public void send(String send){
    	try{
    //		osw = new OutputStreamWriter(me.getOutputStream());
    		osw.write(send);
    		osw.flush();
    		//osw.close();
//    		osw.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public String get(String get) throws Exception{
    	if(get.indexOf("?")>-1){
    		if(get.indexOf("&")>-1){
    			String[] part = get.substring(get.indexOf("?")+1).split("&");
    			for(String s:part){
    				urlParams.put(s.split("=")[0],s.split("=")[1]);
    			}
    		}else{
    			urlParams.put(get.substring(get.indexOf("?")+1,get.indexOf("=")), get.substring(get.indexOf("=")+1,get.length()));
    		}
    		get=get.substring(0,get.indexOf("?"));
    	}
    	

    	String fileData="";
    	
	    if(get.equals("/"))get="index.html";
	    
	    if(get.endsWith(".html")){		    
	    	br=new BufferedReader(new FileReader(new File(root+get)));
		    String line="";	       
		    while((line=br.readLine())!=null){
		    	fileData+=line;
		    }
		    //br.close();
	    	return "HTTP/1.1 200 OK\r\n"+
					"Content-Type: text/html; charset=UTF-8\r\n"+
					"Content-Encoding: UTF-8\r\n"+
					"Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)\r\n"+
					"Accept-Ranges: bytes\r\n"+
				//	"Connection: close\r\n"+
					"\r\n"+
			fileData;
	    }else if(get.endsWith(".jpg")){
	    //	 br=new BufferedReader(new FileReader();
	    	File f= new File(root+get);
	    	//Writer out = new BufferedWriter(new OutputStreamWriter(me.getOutputStream()));
	    	
	    	osw.write( "HTTP/1.1 200 The file is coming right up!\r\n" +
	    			"Server: MyOwnServer\r\n" +
	    			"Content-Length: " + f.length() + "\r\n" +
	    			"Content-Type: image/jpg\r\n" + 
	    			//"Content-Disposition: inline;filename=\""+root+get+";\"\r\n" +
	    			"\r\n");
	    	osw.flush();
	    	OutputStream out2 = me.getOutputStream();
	    	
	    	Path path = Paths.get(root+get);
	    	byte[] data = Files.readAllBytes(path);
	    	out2.write(data);

	    	return "";

	    }else if(get.endsWith(".ops")){
	    	
	    }
	    return "";
    }
     
	
}
