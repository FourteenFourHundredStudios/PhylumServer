package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class WhoQuery extends Query{

	public WhoQuery(String fileData){
		super(fileData);
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NN","NNS","NNP","NNPS","VB","VBD");
	}
	
}
