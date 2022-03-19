package domain;

import org.apache.log4j.Logger;

import java.sql.*;


public class ConnectionManager {
 //region Connection
    final static Logger log = Logger.getLogger(ConnectionManager.class);

    public Connection getConnection(String URL, String username, String pass){
        try (Connection con = DriverManager.getConnection(URL, username, pass);)
        {
             return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion
    public Connection getConnection(String configName){
        ConfigReader cr = new ConfigReader(configName);
        try(Connection con = DriverManager.getConnection(cr.getURL(), cr.getUsername(), cr.getPass()))
        {
            return con;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
