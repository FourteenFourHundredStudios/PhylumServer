package com.fourteenfourhundredstudios.phylum.onepage;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ServerPage {

	 public Map<String,String> urlParams=new HashMap<String,String>();
	 public OutputStream op;
	 public String file;
	 
	 public ServerPage(String file,OutputStream op,HashMap<String,String> urlParams ){

		 this.file="FileSystem/"+file;
		 this.urlParams=urlParams;
		 this.op=op;

	 }
	 
	 public String getHeader(){
		 return null;
	 }
	 
	 public String getData(){
		 return null;
	 }
	 
	 public void sendResponse(){
		 try{
			 OutputStreamWriter osw = new OutputStreamWriter(op);
			 osw.write(getHeader());
			 osw.flush();
			 osw.write(getData());
			 osw.flush();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }
	
}
  