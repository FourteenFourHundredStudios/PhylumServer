package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class Query {
	
	String query;
	
	public Query(String query){
		this.query=query;
	}
	
	public void printTypes(){
		ArrayList<String[]> types= NPLHandler.getPos(query);
		for(String[] type : types){
			System.out.println("["+type[0]+","+type[1]+"]");
		}
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
		return null;
	}
	

	
}
