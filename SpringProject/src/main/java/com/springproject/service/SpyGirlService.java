package com.springproject.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ujNev")
@Scope(value="prototype")
public class SpyGirlService {

	public String iSaySomething() {
		return "Én egy kém vagyok!";
	}
}
