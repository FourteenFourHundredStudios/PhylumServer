package com.fourteenfourhundredstudios.phylum.questions;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fourteenfourhundredstudios.phylum.Utilities;

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
	
	public ArrayList<String> getAnswer(){
		ArrayList<String> answers=new ArrayList<String> ();
		
		//arraylist of relevent words from question
		ArrayList<String> matches=getMatch();
		
		File folder = new File("Websites/");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      //if (listOfFiles[i].isFile()) {
		    	try{
		    		String json=(Utilities.readLine(listOfFiles[i].getPath()));
		    		JSONObject jo = new JSONObject(json);
		    		JSONArray topics= jo.getJSONArray("topics");
		    		
		    	}catch(Exception e ){
		    		e.printStackTrace();
		    		System.out.println("Could not parse JSON");
		    	}
		    	
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
