package dev.javadrinker.gleam.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtil {

    // ** NOT IN USE, PLEASE IGNORE! **

    public static boolean ensureUserData(long userId) throws SQLException {
        String cmd =
                "IF NOT EXISTS ( SELECT 1 FROM user_info WHERE user_id = "+userId+" ) THEN " +
                        "    INSERT INTO user_info (user_id) VALUES ("+userId+");\n" +
                        "END IF;";

        MySqlConnection.execute(cmd);
        return true;
    }
}
