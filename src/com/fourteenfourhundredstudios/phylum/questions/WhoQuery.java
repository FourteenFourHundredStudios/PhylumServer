package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class WhoQuery extends Query{
	//this is my epic change from adam
	//this is my epic change from Marc
	public WhoQuery(String fileData){
		super(fileData);
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NN","NNS","NNP","NNPS","VB","VBD");
	}
	
}
