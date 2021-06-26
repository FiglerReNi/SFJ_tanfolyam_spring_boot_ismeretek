/* Futtatás:  Run As -> Spring Boot App
 * Megcsinál mindent az Ide, elindítja a tomcat szervert is.
 * Minden változtatás után újra kell fordítani a kódot.*/

package com.springproject;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//Felül lehet írni, ha az alapbeállításokon kell módosítani, megmondhatjuk, hogy mit hagyjon ki az autokonfigurációból
//@EnableAutoConfiguration(exclude=)
//Ezzel az annotációval engedélyezzük a csoportos konfigurációt
@EnableConfigurationProperties
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
	/*Profilok használata, ha a POJO nem bean, ha csinálunk egy harmadik profil nevű bean-t is, ahol nincs @Profile annotáció, akkor
	 * azt választja a program, az felülírja az egyéb Bean-eket.*/
	@Bean(name = "profil")
	@Profile("dev")
	public PersonProfile giveMePersonDev() {
		return new PersonProfile("teszt1");
	}
	
	@Bean(name = "profil")
	@Profile("prod")
	public PersonProfile giveMePersonProd() {
		return new PersonProfile("teszt2");
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
		
		//Ilyenkor a toString-et adja vissza, ami minden objektumnek van és módosítható
		System.out.println(container.getBean("personPlus"));
		
		System.out.println(container.getBean("person"));
		
		System.out.println(container.getBean("profil"));
	}
}
