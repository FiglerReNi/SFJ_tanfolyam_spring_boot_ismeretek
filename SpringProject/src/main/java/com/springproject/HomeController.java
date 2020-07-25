package com.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	/*tightly coupled, ha így csináljuk minden alkalommal új objektum jön létre,amikor meghívódik az osztály. 
	Jelen esetben a restcontroller singleton ezért egyetlen egyszer fog létrejönni, ez így nem jó, mert mi sessiononként szeretnénk
	új SpyGirl objektumot
	Nem használjuk ki a container lehetőségeit és a dependency injectiont
	private SpyGirl spicy = new SpyGirl();*/
	
	/*Dependency Injection 1.
	@Autowired
	private SpyGirl spicy;*/
	
	//Dependency Injection 2.
	private SpyGirl spicy;
	@Autowired
	public void setSpicy(SpyGirl spicy) {
		this.spicy = spicy;
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
}
