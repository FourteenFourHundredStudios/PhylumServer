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
		    		boolean canUse=false;
		    		for(String s:matches){
		    		//	System.out.println(JSO)
			    		if(json.contains(s)){

			    			/*
			    			count matching words for pageRate
			    			JSONObject jo = new JSONObject(json);
			    			 * JSONArray topics= jo.getJSONArray("topics");
			    			 
			    			for(int x=0;x<topics.length();x++){
			    				
			    			}*/
			    			
			    			canUse=true;
			    			
			    			//do not break if getting page rate
			    			break;
			    		}
		    		}
		    		if(!canUse)continue;
		
		    		String[] fileLines=Utilities.readFile(listOfFiles[i].getPath()).split("\n");
		    	//	System.out.println("fefe "+fileLines[1]);
		    		
		    		String[] sentences =fileLines[1].split("\\.");
		    		
		    		for(String sentence:sentences){
		    			boolean isAnswer=true;
		    		
		    			/*
		    			String[] words=sentence.split(" ");
		    			for(String word:words){
		    				if(!(sentence.contains(word))){
		    					isAnswer=false;
		    					break;
		    				}
		    			}
		    			*/
		    			
		    		//	System.out.println(match);
		    			
		    			for(String match:matches){
		    				
		    				if(!(sentence.contains(match))){
		    					isAnswer=false;
		    				}
		    			}
		    			if(isAnswer){
		    				answers.add(sentence);
		    			}
		    		}
		    	}catch(Exception e ){
		    		e.printStackTrace();
		    		System.out.println("Could not parse JSON or something");
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
