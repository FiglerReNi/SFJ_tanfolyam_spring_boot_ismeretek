package com.springproject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Ezzel az annotációval jelezzük hogy ő egy bean, az életciklusa pedig session.
@Component
@Scope(value="prototype")
public class SpyGirl {

	public String iSaySomething() {
		return "Én egy kém vagyok!";
	}
}
