package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class WhoQuery extends Query{
	
	public WhoQuery(String fileData,String[] text){
		super(fileData,text);
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NNP","NN","VB","VBD");
	}
	
}
