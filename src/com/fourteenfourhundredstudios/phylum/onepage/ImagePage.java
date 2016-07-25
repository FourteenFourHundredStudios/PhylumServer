package com.fourteenfourhundredstudios.phylum.onepage;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ImagePage extends ServerPage{

	long length=0;
	String imageType;
	
	public ImagePage(String file,OutputStream op,HashMap<String,String> urlParams,String imageType) {
		super(file,op,urlParams);
		this.imageType=imageType;
		File f= new File(this.file);
		length=f.length();
	}
	
	public String getData(){
		try{
			Path path = Paths.get(file);
			byte[] data = Files.readAllBytes(path);
			op.write(data);
			op.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public String getHeader(){
		return
			"HTTP/1.1 200 The file is coming right up!\r\n" +
		    "Server: OnePage\r\n" +
		    "Content-Length: " + length + "\r\n" +
		    "Content-Type: image/"+imageType+"\r\n" + 
		    "\r\n";
	}
	
	
}
