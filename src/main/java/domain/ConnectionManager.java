package domain;

import org.apache.log4j.Logger;

import java.sql.*;


public class ConnectionManager {

    final static Logger log = Logger.getLogger(ConnectionManager.class);

    public Connection getConnection(String URL, String username, String pass){
        try (Connection con = DriverManager.getConnection(URL, username, pass);)
        {
             return con;
        } catch (SQLException ex) {
            ex.getLocalizedMessage();
        }
        return null;
    }







}
