package com.improving.tagcliredo;

import com.improving.tagcliredo.database.DatabaseClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TagcliredoApplication implements CommandLineRunner {

	private final DatabaseClient databaseClient;

	public TagcliredoApplication(DatabaseClient databaseClient) {
		this.databaseClient = databaseClient;
	}


	public static void main(String[] args) {
		SpringApplication.run(TagcliredoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		databaseClient.insertIntoTable();
		databaseClient.readWeaponsFromTable();
	}

}



