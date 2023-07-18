package com.uch.vueproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class VueprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueprojectApplication.class, args);
	}

}
