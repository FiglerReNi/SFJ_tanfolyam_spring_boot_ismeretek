/* Futtatás:  Run As -> Spring Boot App
 * Megcsinál mindent az Ide, elindítja a tomcat szervert is.
 * Minden változtatás után újra kell fordítani a kódot.*/

package com.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*Az alsó hármat váltja ki a legfelső*/
/*@SpringBootApplication*/
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
