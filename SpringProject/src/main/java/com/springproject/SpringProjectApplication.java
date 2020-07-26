/* Futtatás:  Run As -> Spring Boot App
 * Megcsinál mindent az Ide, elindítja a tomcat szervert is.
 * Minden változtatás után újra kell fordítani a kódot.*/

package com.springproject;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Ha más package-ban is meg akarjuk keresni a bean-eket, akkor felül kell írnunk a @ComponentScan annotációt, hiába van benne egyébként a @SpringBootApplication-ban
@ComponentScan({"com.springproject", "com.beansearch"})
@SpringBootApplication
/*Az alsó hármat váltja ki a legfelső*/
/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
public class SpringProjectApplication {

	//POJO-ból bean objektum
	@Bean
	public Person giveMePerson() {
		return new Person("Gyula", 20);
	}
	
	public static void main(String[] args) {		
		//ennek a visszatérési értéke a container
		ApplicationContext container = SpringApplication.run(SpringProjectApplication.class, args);
		//Kiolvassuk miért felel a container
		String[] beanArray = container.getBeanDefinitionNames();
		Arrays.sort(beanArray);
		for(String name:beanArray) {
			System.out.println(name);
		}
	}
}
