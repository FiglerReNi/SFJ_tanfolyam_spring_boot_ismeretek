package com.springproject.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Ezzel az annotációval jelezzük hogy ő egy bean, az életciklusa pedig session.
@Component("ujNev")
@Scope(value="prototype")
public class SpyGirlService {

	public String iSaySomething() {
		return "Én egy kém vagyok!";
	}
}
