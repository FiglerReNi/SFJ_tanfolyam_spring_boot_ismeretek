package com.springmasodik.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmasodik.domain.Story;

@Controller
public class HomeController {
	
	/*templates mappában keresi a stories nézetet*/
	@RequestMapping("/")
	/*a Model az átjáró a backend és a frontend között*/
	public String stories(Model model) {
		/*itt határozzuk meg milyen értéket akarunk átadni a html-nek és annak mi lesz az id-ja*/
		model.addAttribute("pageTitle", "Minden napra egy sztori");
		model.addAttribute("stories", getStories());
		return "stories";
	}
	
	private ArrayList<Story> getStories(){
		ArrayList<Story> stories = new ArrayList<>();
		
		Story story1 = new Story();
		story1.setTitle("Első sztorim");
		story1.setPosted(new Date());
		story1.setAuthor("FReni");
		/*Adhatunk át html-t is, de ezt a html oldal is csinálhatja*/
		story1.setContent("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ac lorem non tortor efficitur posuere eu nec est. Sed molestie rhoncus metus id pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur tempus, orci ut volutpat aliquet, turpis lectus eleifend nunc, vehicula molestie mauris libero a nibh. Aenean nec tristique magna. Vestibulum sit amet enim pharetra, euismod nisi ac, finibus nisl. Quisque imperdiet vitae nibh ac varius. </p>");
	
		Story story2 = new Story();
		story2.setTitle("Második sztorim");
		story2.setPosted(new Date());
		story2.setAuthor("Stephy");
		/*Adhatunk át html-t is, de ezt a html oldal is csinálhatja*/
		story2.setContent("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ac lorem non tortor efficitur posuere eu nec est. Sed molestie rhoncus metus id pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur tempus, orci ut volutpat aliquet, turpis lectus eleifend nunc, vehicula molestie mauris libero a nibh. Aenean nec tristique magna. Vestibulum sit amet enim pharetra, euismod nisi ac, finibus nisl. Quisque imperdiet vitae nibh ac varius. </p>");
	 
		stories.add(story1);
		stories.add(story2);
		
		return stories;
	}

}
