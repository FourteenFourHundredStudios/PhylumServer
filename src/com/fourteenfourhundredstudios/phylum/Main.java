package com.fourteenfourhundredstudios.phylum;

import java.util.ArrayList;

import com.fourteenfourhundredstudios.phylum.html.HTMLParser;
import com.fourteenfourhundredstudios.phylum.questions.NPLHandler;
import com.fourteenfourhundredstudios.phylum.questions.Query;
import com.fourteenfourhundredstudios.phylum.questions.WhoQuery;

public class Main {

	public Main(){
		
		NPLHandler.load();
		//
		//ArrayList<String> nouns=query.getNouns();
		
		HTMLParser hp = new HTMLParser(Utilities.readFile("Websites/Java2.html"));
		String text= hp.getText("script","h1","h2","h3","h4","h5","ul","style","title","a");
		WhoQuery query = new WhoQuery("who created Java");
		
		ArrayList<String> matches=query.getMatch();
		query.printTypes();
		
		String[] sentences = Utilities.getSentences(text);
		
		
		for(String sentence : sentences){
			boolean isAnswer=true;
			for(String match: matches){
				if(!sentence.contains(match)){
					isAnswer= false;
				}
			}
			if(isAnswer)System.out.println("Answer: "+sentence);
		}
		
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
