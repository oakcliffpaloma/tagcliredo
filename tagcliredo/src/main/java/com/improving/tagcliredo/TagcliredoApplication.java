package com.improving.tagcliredo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TagcliredoApplication implements CommandLineRunner {

	private final TagCliEmote tagCliEmote;

	public TagcliredoApplication(TagCliEmote tagCliEmote) {
		this.tagCliEmote = tagCliEmote;
	}

	public static void main(String[] args) {
		SpringApplication.run(TagcliredoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// databaseClient.insertIntoTable();
		// databaseClient.readEmoteFromTable();
        tagCliEmote.execute();
	}

}



