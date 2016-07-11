package com.fourteenfourhundredstudios.phylum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HTMLParser {

	private static BufferedReader br;

	public static String parse(String html){
		int count=0;
		String str="";
		boolean inHtml=false;
		for(int i=0;i<html.length();i++){
			String c = html.substring(i,i+1);
			if(c.equals("<")){
				count++;
				inHtml=true;
			}else if(c.equals(">")){
				count --;
				if(count == 0 ){  
					inHtml=false;
				}
			}else if(!inHtml){
				str+=c;
			}
		}
		return str;
	}
	
	public static String readFile(String fn){
		String f ="";
		try{
			br = new BufferedReader(new FileReader(new File(fn)));
			while(br.ready()){
				f+=br.readLine()+"\n";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	
}
