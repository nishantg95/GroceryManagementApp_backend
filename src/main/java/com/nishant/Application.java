/**
 *
 */
package com.nishant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nishant.b.grover
 *
 */
@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@ComponentScan("com.nishant")
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
