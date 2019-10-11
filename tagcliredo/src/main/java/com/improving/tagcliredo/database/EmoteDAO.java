package com.improving.tagcliredo.database;

import com.improving.tagcliredo.models.Emote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EmoteDAO {
    private final JdbcTemplate jdbcTemplate;
    Scanner scanner = new Scanner(System.in);


    private static final Logger logger =
            LoggerFactory.getLogger(DatabaseClient.class);

    public EmoteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Create Operation
    public boolean insertEmote(Emote emote) {
        //public void insertIntoTable(Emote emote) {
            try {
                int rowsAffected = jdbcTemplate.update(
                        "INSERT INTO emote (Prompt, Text) " +
                                "VALUES ('" + emote.getPrompt() + "', '" + emote.getText() + "')");
                logger.info("Rows Affected : {}", rowsAffected);
                return true;
            } catch (DataAccessException e) {
                logger.error("Exception throw in JDBC: ", e);
            }
            return false;
        }

    //Read Operation

    public Emote selectEmote(String name){
        try {
            List<Emote> emotes = jdbcTemplate.query("SELECT * FROM emote WHERE Name = '" + name + "'",
                    (result, rowNum) ->
                            new Emote(
                                    result.getString("Prompt"),
                                    result.getString("Text")));

            emotes.forEach(emote ->System.out.println(emote.getPrompt() + ": "+ emote.getText()));
            if (emotes.size()==0){
                return null;
            }
            return emotes.get(0);
        } catch(DataAccessException e){
            System.out.println("Exception throw in jbdc: " + e);
        } return null;
    }

    //Update Operation
    public boolean updateEmote(Emote emote){
        throw new RuntimeException("Not Implemented Yet");
    }

    //Delete Operation

    public boolean deleteEmote(Emote emote){
        throw new RuntimeException("Not Implemented Yet");
    }

    public void insertIntoTable(Emote emote) {
    }
}
