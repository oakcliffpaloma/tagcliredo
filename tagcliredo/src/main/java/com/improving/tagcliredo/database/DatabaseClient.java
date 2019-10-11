package com.improving.tagcliredo.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseClient {

    private static final Logger logger =
            LoggerFactory.getLogger(DatabaseClient.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseClient(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   /* public List<Emote> readEmoteFromTable() {
        try {
            List<Emote> emotes = jdbcTemplate.query("SELECT * FROM Emote LIMIT 10", (result, rowNum) ->
                    new Emote(result.getInt("Id"),
                            result.getString("prompt"),
                            result.getString("text")));
            emotes.forEach(emote ->
                    logger.info("Emote ID: {}, Prompt: {}, Text: {}", emote.getId(), emote.getPrompt(), emote.getText()));
            return emotes;

        } catch (DataAccessException e) {
            logger.error("Error: ", e);
        }
        return Collections.EMPTY_LIST;
    }*/

    /*public void insertIntoTable(Emote emote) {
        try {
            int rowsAffected = jdbcTemplate.update(
                    "INSERT INTO emote (Prompt, Text) " +
                            "VALUES ('" + emote.getPrompt() + "', '" + emote.getText() + "')");
            logger.info("Rows Affected : {}", rowsAffected);
        } catch (DataAccessException e) {
            logger.error("Exception throw in JDBC: ", e);
        }
    }*/
}

