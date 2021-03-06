package com.springmasodik.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Általános kivételkezelő osztály, minden átdobott kivételt ez kezel

@ControllerAdvice
public class ExceptionGeneral {
	
	@ExceptionHandler
	public String exceptionHandler(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		return "exceptionHandler";
	}
}
