package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class WhatQuery extends Query{

	public WhatQuery(String query) {
		super(query);
		
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NN","NNS","NNPS","VB","VBD");
	}
	

}
