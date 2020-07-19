package com.springproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	/*Ezzel adom meg, hogy milyen útvonalnál hívódjon meg ez a függvény*/
	@RequestMapping("/")
	public String index() {
		return "Szia FReni";
	}
}
