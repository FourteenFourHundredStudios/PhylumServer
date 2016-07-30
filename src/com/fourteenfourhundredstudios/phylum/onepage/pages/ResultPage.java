package com.fourteenfourhundredstudios.phylum.onepage.pages;

import java.io.OutputStream;
import java.util.HashMap;

import com.fourteenfourhundredstudios.phylum.Utilities;
import com.fourteenfourhundredstudios.phylum.html.HTMLParser;
import com.fourteenfourhundredstudios.phylum.onepage.HTMLPage;
import com.fourteenfourhundredstudios.phylum.questions.Query;
import com.fourteenfourhundredstudios.phylum.questions.WhoQuery;

public class ResultPage extends HTMLPage{

	public ResultPage(String file, OutputStream op, HashMap<String, String> urlParams) {
		super(file, op, urlParams);

	}
	
	public String getData(){
		String HTML="<title>Phylum Results</title><div align='center'>";
		


		Query query = new Query(urlParams.get("searchBox"));
		query.printTypes();
		
		for(String answer:query.getAnswer()){
			HTML+= "<div align='center'  style='width:700px;height:200px;border:1px solid #000;'>"+answer+"</div><br>";
			//HTML+= answer;
		}
		HTML+="</div>";
		return HTML;
	}

}
