package com.fourteenfourhundredstudios.phylum.questions;

import java.util.*;

import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;


//import java.util.Properties;

public class NPLHandler {

	static StanfordCoreNLP pipeline;
	static Properties props;
	
	//loads npl handler
	public static void load(){
		props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos");
		pipeline = new StanfordCoreNLP(props);
	}
	//returns parts of speech for each world in a arraylist
	public static ArrayList<String[]> getPos(String s){
		String text = s;
		ArrayList<String[]> tokenlist = new ArrayList<String[]>();
		Annotation document = new Annotation(text);
		pipeline.annotate(document);
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);		
		for(CoreMap sentence: sentences){
			 for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
				 String pos = token.get(PartOfSpeechAnnotation.class);
				 tokenlist.add(new String[]{token.value(),pos});
			 }
		}
		return tokenlist;
	}
	

}