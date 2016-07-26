package com.fourteenfourhundredstudios.phylum.onepage.pages;

import java.io.OutputStream;
import java.util.HashMap;

import com.fourteenfourhundredstudios.phylum.onepage.HTMLPage;
import com.fourteenfourhundredstudios.phylum.onepage.ServerPage;


public class ErrorPage extends HTMLPage{

	public ErrorPage(String file, OutputStream op, HashMap<String, String> urlParams) {
		super(file, op, urlParams);
	}
	
	public String getData(){
		String HTML="<title>Phylum Error</title>";
		
		HTML+="<hr><h1>404 Page not found</h1><div align='center'><hr><br>";
		HTML+="<h3>Could not find: "+file.substring(file.indexOf("//")+1)+"</h3>";
		HTML+="</div>";
		
		
		return HTML;
	}
	
}


/*
 {
 'website':'wikipedia.com/wolves'
 'subject':['wolves','dads'],
 'date':'06/06/06'
 } 
*/