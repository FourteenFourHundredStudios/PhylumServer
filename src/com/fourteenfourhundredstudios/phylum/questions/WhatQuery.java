package com.fourteenfourhundredstudios.phylum.questions;

import java.util.ArrayList;

public class WhatQuery extends Query{

	public WhatQuery(String query, String[] text) {
		super(query, text);
		
	}
	
	public ArrayList<String> getMatch(){
		return getPosWordType("NN","NNS","NNPS","VB","VBD");
	}
	

}
