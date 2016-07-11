package com.fourteenfourhundredstudios.phylum;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;


//import java.util.Properties;

public class Main {

	StanfordCoreNLP pipeline ;
	
	public Main(){
		
		/*
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos");
		pipeline = new StanfordCoreNLP(props);
		
		Scanner s = new Scanner(System.in);
		
		
		
		while(true){
			getStuff(s.nextLine());
		}
		*/
		String file=(HTMLParser.readFile("Websites/Java.html"));
		System.out.println(HTMLParser.parse(file));
		
	}
	
	public void getStuff(String s){

		

		String text = s;

		Annotation document = new Annotation(text);

		pipeline.annotate(document);
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);

		for(CoreMap sentence: sentences) {
			 for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
				 String pos = token.get(PartOfSpeechAnnotation.class);
				 System.out.println(pos);
			 }
			
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
