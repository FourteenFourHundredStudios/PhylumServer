package com.fourteenfourhundredstudios.phylum.questions;

public class Answer {

	public int pageRate;
	public String answerVal;
	
	public Answer(int pageRate,String answerVal){
		this.pageRate=pageRate;
		this.answerVal=answerVal;
	}
	
	public int getPageRate(){
		return pageRate;
	}
	
	public String getAnswer(){
		return answerVal;
	}
	
}
