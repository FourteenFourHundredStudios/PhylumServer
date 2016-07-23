package com.fourteenfourhundredstudios.phylum;


import com.fourteenfourhundredstudios.phylum.html.HTMLParser;
import com.fourteenfourhundredstudios.phylum.questions.NPLHandler;
import com.fourteenfourhundredstudios.phylum.questions.WhoQuery;

public class Main {

	public Main(){
		
		//GITHUB WORKS!!!
		
		NPLHandler.load();
		//
		//ArrayList<String> nouns=query.getNouns();
		
		HTMLParser hp = new HTMLParser(Utilities.readFile("Websites/WWII 2.html"));
		String text= hp.getText("script","h1","h2","h3","h4","h5","ul","style","title","head");
		String[] sentences = Utilities.getSentences(text);
		//System.out.println("ddd");

		
		WhoQuery query = new WhoQuery("Who acheived agreement with Hitler",sentences);
		query.printTypes();
		
		for(String answer:query.getAnswer()){
			System.out.println("Answer: "+answer);
		}
		
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
