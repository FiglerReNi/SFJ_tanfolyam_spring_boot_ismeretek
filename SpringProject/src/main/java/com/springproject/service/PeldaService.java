package com.springproject.service;

import org.springframework.stereotype.Service;

//Ez is bean lesz (speciális)
@Service("peldaNev")
public class PeldaService {

	public String pelda() {
		return "Példa Service";
	}
}
