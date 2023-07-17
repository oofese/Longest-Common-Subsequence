package com.example.restservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWords{
	private  WordService service=new WordService();
	 
	
	@GetMapping("/words")
	public ModelWords wordsGet() {
		return null;
		
	}
	
	
	@PostMapping("/words")
    public ModelWords wordsPost (@RequestParam String firstWord,String secondWord){	 
		return  service.checkWord(firstWord, secondWord);	
    }
	
}