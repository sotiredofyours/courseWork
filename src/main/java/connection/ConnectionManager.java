package connection;

import databaseconfig.ConfigReader;
import lombok.extern.log4j.Log4j;
import java.sql.*;


@Log4j
public class ConnectionManager {

    public Connection getConnection(String URL, String username, String pass) {
        try {
            return DriverManager.getConnection(URL, username, pass);
        } catch (SQLException e) {
            log.error("Connect to DB error(w/o config)");
        }
        return null;
    }

    public Connection getConnection(String configName) {
        ConfigReader cr = new ConfigReader(configName);
        try {
            return DriverManager.getConnection(cr.getURL(), cr.getUsername(), cr.getPassword());
        } catch (SQLException e) {
            log.error("Connect to DB error");
        }
        return null;
    }
}
