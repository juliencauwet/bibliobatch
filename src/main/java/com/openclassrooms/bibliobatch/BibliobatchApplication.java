package com.openclassrooms.bibliobatch;

import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliobatchApplication {

	private static final Logger log = Logger.getLogger(BibliobatchApplication.class);

	public static void main(String[] args) {
		log.info("Entrée dans l'application");

		SpringApplication.run(BibliobatchApplication.class, args);
	}
}
