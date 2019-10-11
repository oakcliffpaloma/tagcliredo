package com.improving.tagcliredo;
import com.improving.tagcliredo.database.EmoteDAO;
import com.improving.tagcliredo.models.Emote;
import com.improving.tagcliredo.models.ItemDAO;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TagCliEmote {
    private final EmoteDAO emoteDAO;
    private final ItemDAO item;
    private Scanner scanner = new Scanner(System.in);
    //private DatabaseClient databaseClient;

    private Emote emote;

    public TagCliEmote(EmoteDAO emoteDAO, ItemDAO item) {
        //this.databaseClient = databaseClient;
        this.emoteDAO = emoteDAO;
        this.item = item;
    }
    public void run() {
        Emote readEmote = emoteDAO.selectEmote("Dance");
        System.out.println("Emote found; " + readEmote.getPrompt() + "-");
    }
    public void execute() {
        System.out.println("Do you want to (1) Add Something or (2) Read Something?");
        boolean loop = true;
        while (loop) {
            var input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {
                System.out.println("Do you want to add an (1) Emote or (2) Weapon?");
            } else {
                if (!input.equalsIgnoreCase("1")) {
                    System.out.println("huh?");
                    continue;
                }
            }

            input = scanner.nextLine();
            if (input.equalsIgnoreCase("1")) {
                System.out.println("What would you like for your prompt to be?");
            } else {
                if (!input.equalsIgnoreCase("Emote")) {
                    System.out.println("Sorry, that's not an option.");
                    continue;
                }
            }

            if (input != null) {
                String foo = scanner.nextLine();
                System.out.println("What would you like for your text to be?");
                String bar = scanner.nextLine();
                Emote emote = new Emote(0, foo, bar);
                emoteDAO.insertIntoTable(emote);
            } else {
                continue;
            }

            System.out.println("SUCCESS!");
        }

    }




    /*public void execute() {
        int choice = input.nextInt();
        System.out.print(">");
        System.out.print("Do you want to (1) Add something or (2) Read Something?");

        boolean loop = true;
        while (loop) {
            //int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("Would you like to [1] Add Emote, [2] Add Weapon");
            }
//            if (choice == 2) {
//                System.out.println("Would you like to [1] Add Emote, [2] Add Weapon");
            choice = input.nextInt();
            if (choice == 1) {
                databaseClient.insertIntoTable(emote);
                System.out.println("What do you want the prompt to be?");
            }
            choice = input.nextLn();
        }
    }*/
}
