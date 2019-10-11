package com.improving.tagcliredo.models;

public class Emote {
    private int id;
    private String prompt;
    private String text;

    public Emote(String prompt, String text) {
    }

    public int getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Emote(int id, String prompt, String text) {
        this.id = id;
        this.prompt = prompt;
        this.text = text;
    }

/*}



    public void insertEmoteTable(Emote emote) {
        try {
            int rowsAffected = jdbcTemplate.update(
                    "INSERT INTO emote (Prompt, Text) " + "VALUES ('Dance', 'You dance like a happy banana')");
            logger.info("Rows Affected : {}", rowsAffected);
        } catch (DataAccessException e) {
            logger.error("Exception throw in JDBC: ", e);
        }*/
    }

