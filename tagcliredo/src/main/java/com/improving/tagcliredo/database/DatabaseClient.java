package com.improving.tagcliredo.database;

import com.improving.tagcliredo.models.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DatabaseClient {

    private static final Logger logger =
            LoggerFactory.getLogger(DatabaseClient.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseClient(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Weapon> readWeaponsFromTable() {
        try{
            List<Weapon> weapons = jdbcTemplate.query("SELECT * FROM weapon LIMIT 10", (result, rowNum) ->
                            new Weapon(result.getInt("Id"),
                                result.getString("Name"),
                                result.getString("area"),
                                result.getString("itemType")));
            weapons.forEach(weapon ->
                    logger.info("Weapon ID: {}, Name: {}", weapon.getId(), weapon.getName()));
            return weapons;

        } catch (DataAccessException e) {
            logger.error("Error: ", e);
        }
        return Collections.EMPTY_LIST;
    }




    public void insertIntoTable() {
        try {
            int rowsAffected = jdbcTemplate.update(
                    "INSERT INTO weapon (Name, Area, ItemType) " + "VALUES ('SMALLISH DAGGER', 'Dagger shop', 'Weapon')");
            logger.info("Rows Affected : {}", rowsAffected);
        } catch (DataAccessException e) {
            logger.error("Exception throw in JDBC: ", e);
        }
    }
}
