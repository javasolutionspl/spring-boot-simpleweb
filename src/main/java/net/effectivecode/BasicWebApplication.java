package net.effectivecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "net.effectivecode")
public class BasicWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicWebApplication.class, args);
	}

}
