package com.springmasodik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/*templates mappában keresi a stories nézetet*/
	@RequestMapping("/")
	/*a Model az átjáró a backend és a frontend között*/
	public String stories(Model model) {
		/*itt határozzuk meg milyen értéket akarunk átadni a html-nek és annak mi lesz az id-ja*/
		model.addAttribute("pageTitle", "Minden napra egy sztori");
		return "stories";
	}

}
