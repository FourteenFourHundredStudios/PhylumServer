package com.fourteenfourhundredstudios.phylum.onepage;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImagePage extends ServerPage{

	long length=0;
	
	public ImagePage(String file,OutputStream op) {
		super(file,op);
		File f= new File(file);
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
		    "Server: MyOwnServer\r\n" +
		    "Content-Length: " + length + "\r\n" +
		    "Content-Type: image/jpg\r\n" + 
		    "\r\n";
	}
	
	
}
