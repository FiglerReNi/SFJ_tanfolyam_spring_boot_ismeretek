package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.service.PeldaService;
import com.springproject.service.SpyGirlService;

//Ez is bean lesz (speciális)
@RestController
public class HomeController {
	//kiolvasás yaml fájl értéket
	@Value("${HomeController.msg}")
	private String message;
	@Value("${HomeController.random}")
	private String rand;
	@Value("${HomeController.szam}")
	private long teszt1;
	@Value("${HomeController.number}")
	private int teszt2;
	@Value("${HomeController.tartomany}")
	private int teszt3;
	/*tightly coupled, ha így csináljuk minden alkalommal új objektum jön létre,amikor meghívódik az osztály. 
	Jelen esetben a restcontroller singleton ezért egyetlen egyszer fog létrejönni, ez így nem jó, mert mi sessiononként szeretnénk
	új SpyGirl objektumot
	Nem használjuk ki a container lehetőségeit és a dependency injectiont
	private SpyGirl spicy = new SpyGirl();*/
	
	/*Dependency Injection 1.
	@Autowired
	private SpyGirl spicy;*/
	
	//Dependency Injection 2.
	private SpyGirlService spicy;
	@Autowired
	public void setSpicy(SpyGirlService spicy) {
		this.spicy = spicy;
	}
	
	private PeldaService pelda;
	@Autowired
	public void setPelda(PeldaService pelda) {
		this.pelda = pelda;
	}

	/*Dependency Injection 3.
	private SpyGirl spicy;
	@Autowired
	public HomeController(SpyGirl spicy) {
		this.spicy = spicy;
	}*/
	

	/*Ezzel adom meg, hogy milyen útvonalnál hívódjon meg ez a függvény*/
	@RequestMapping("/")
	public String index() {
		//return "Szia Reni";
		return spicy.iSaySomething();
	}
	
	@RequestMapping("/test")
	public String test() {
		//return "Szia Reni";
		return pelda.pelda();
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return message;
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return rand + " " + teszt1 + " " + teszt2 + " " + teszt3;
	}
}
