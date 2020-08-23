package com.springmasodik.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmasodik.domain.Story;
import com.springmasodik.service.TortenetService;

@Controller
public class HomeController {
	private TortenetService tortenetService;
	
	@Autowired
	public void setTortenetService(TortenetService tortenetService) {
		this.tortenetService = tortenetService;
	}
	
	@RequestMapping("/tortenetek")
		public String tortenetek(Model model) {
			model.addAttribute("pageTitle", "Minden napra egy sztori");
			model.addAttribute("tortenetek", tortenetService.getTortenet());
			return "tortenetek";
		}
	
	@RequestMapping("/tortenet")
	public String tortenet(Model model) {
		model.addAttribute("pageTitle", "Minden napra egy sztori");
		model.addAttribute("tortenet", tortenetService.getEgyTortenet());
		return "tortenet";
	}


	/*templates mappában keresi a stories nézetet*/
	@RequestMapping("/")
	/*a Model az átjáró a backend és a frontend között*/
	public String stories(Model model, Locale locale) {
		/*itt határozzuk meg milyen értéket akarunk átadni a html-nek és annak mi lesz az id-ja*/
		model.addAttribute("pageTitle", "Minden napra egy sztori");
		model.addAttribute("stories", getStories());
		//ezzel tudunk kiiratni adatokat a localunkról
		System.out.println(String.format("Request received. Language: %s, Country: %s", locale.getLanguage(), locale.getCountry()));
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
	
	
	//Az útvonalakban lehetnek paraméterek átadva, amikkel tudunk dolgozni (mint php-ben a Get-el url-be írt dolgok)
	@RequestMapping(path = {"/user", "/user/{id}"})
	public String searchForUser(@PathVariable(value="id", required=false) String id) throws Exception{
		//kezelnünk kell ha valamiért mégsincs az id az útvonalban
		if(id == null) {
			//eldobjuk és majd kezeljük egy osztállyal
			throw new Exception("Nincs id megadva!");
		}
		return "stories";
	}
	
	/*cím alaoján keresünk az adattáblában és megjelentjük*/
	@RequestMapping(path = {"/title", "/title/{title}"})
	public String searchForTitle(@PathVariable(value="title", required=false) String title, Model model) throws Exception{
		//kezelnünk kell ha valamiért mégsincs az id az útvonalban
		if(title == null) {
			//eldobjuk és majd kezeljük egy osztállyal
			throw new Exception("Nem adtál meg címet!");
		}
		model.addAttribute("tortenet", tortenetService.getSpecificTortenet(title));
		return "tortenet";
	}
	
	//kezelhetjük az adott helyen vagy külön osztályban is, utóbbi jobb megoldás
    /*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest ra, Exception ex, Model model) {
		model.addAttribute("exception", ex);
		return "exceptionHandler";
	}
	*/

}
