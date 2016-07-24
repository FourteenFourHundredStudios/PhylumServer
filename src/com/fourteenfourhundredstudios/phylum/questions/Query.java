package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class Query {
	
	String query;
	String[] text;
	
	public Query(String query,String[] text){
		this.query=query;
		this.text=text;
	}
	
	public void printTypes(){
		ArrayList<String[]> types= NPLHandler.getPos(query);
		for(String[] type : types){
			System.out.println("["+type[0]+","+type[1]+"]");
		}
	}
	
	public ArrayList<String> getAnswer(){
		
		ArrayList<String> matches=getMatch();
		
		
		ArrayList<String> answers=new ArrayList<String>();
		for(String sentence : text){
			boolean isAnswer=true;
			for(String match: matches){
				if(!sentence.contains(match)){
					isAnswer= false;
				}
			}
			if(isAnswer)answers.add(sentence);
		}
		return answers;
	}
	
	public ArrayList<String> getPosWordType(String... pos){
		ArrayList<String[]> types= NPLHandler.getPos(query);
		ArrayList<String> result= new ArrayList<String>();	
		for(String i: pos){
			for(String[] s:types){
				if(i.equals(s[1])){
					result.add(s[0]);
				}
			}		
		}
		return result;
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NNP","NN","VB","VBD");
	}
	

	
}
