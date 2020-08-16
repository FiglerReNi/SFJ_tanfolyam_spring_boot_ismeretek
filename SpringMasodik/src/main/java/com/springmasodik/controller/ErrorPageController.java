package com.springmasodik.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;


@Controller
public class ErrorPageController implements ErrorController {

	private static final String ERR_PATH = "/error";
	//ez fogja tudni kiszedni a requestből kikért ra-ban lévő adatok közül azt ami az errorhoz kapcsolódik
	private ErrorAttributes errorAttributes;
	
	/*dependency injectionnal csinálom ezt, csak akkor jön létre amikor tényleg kell*/
	@Autowired
	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	//A getErrorPath által irányított útvonalat kapja el és erre küld választ egy saját error oldalra
	//a request objektumot ugyanúgy tudjuk kérni argumentumként a frameworktől mint a modelt
	@RequestMapping(ERR_PATH)
	public String error(Model model, HttpServletRequest request) {
		//ra képes tárolni egy request minden adatát, és a jobb oldal segítségével olvassuk ki ezeket az adatokat
		ServletWebRequest ra = new ServletWebRequest(request);
		//Map: kettesével tárol adatokat, összetett adattípusok mentésére jó
		Map<String, Object> error = this.errorAttributes.getErrorAttributes(ra, true);
		
		//vizsgálhatjuk pl a státszokat és mindegyiknél más viselkedést adhatunk.
		if(error.containsValue(404)) {
			NotFound(error.get("status"));
		}
			
		System.out.print(error);
		
		//átadjuk a modellen keresztül
		/*
		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("status", error.get("status"));
		model.addAttribute("path", error.get("path"));		
		*/
		
		//átadhatjuk egyszerre is, ilyenkor az eredeti nevük marad
		model.addAllAttributes(error);
		return "detailedError";
	}

	public void NotFound(Object status) {
		System.out.print(status);
	}
	
	//Az ErrorController mivel interface, a benne lévő metódusokat meg kell határoznunk, 
	//ez mondja meg, hogy hiba esetén hová irányítsa a felhasználót, milyen útvonalra.
	//Ez mindig /error ebben az esetben
	@Override
	public String getErrorPath() {		
		return ERR_PATH;
	}
	
}
