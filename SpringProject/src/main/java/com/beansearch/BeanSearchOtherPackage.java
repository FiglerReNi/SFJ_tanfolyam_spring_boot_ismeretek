package com.beansearch;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class BeanSearchOtherPackage {

		public String Test() {
			return "Teszt";
		}
}
