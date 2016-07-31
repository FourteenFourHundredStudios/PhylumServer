package com.fourteenfourhundredstudios.phylum;


import com.fourteenfourhundredstudios.phylum.html.HTMLParser;
import com.fourteenfourhundredstudios.phylum.questions.NPLHandler;
import com.fourteenfourhundredstudios.phylum.questions.Query;
import com.fourteenfourhundredstudios.phylum.questions.WhoQuery;

public class Main {

	public Main(){

		
		NPLHandler.load();

		//
		//ArrayList<String> nouns=query.getNouns();
		


		
		Query query = new Query("Who Axis powers");
		query.printTypes();
		
		for(String answer:query.getAnswer()){
			System.out.println("Answer: "+answer);
		}
		
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
