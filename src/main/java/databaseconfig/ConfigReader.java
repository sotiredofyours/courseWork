package databaseconfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Log4j
@Setter
public class ConfigReader {

    private String rbName;

    public ConfigReader(String baseName){
        rbName = baseName;
    }

    public String getURL(){
        try{
            var rb = ResourceBundle.getBundle(rbName);
            var host = rb.getString("host");
            var database = rb.getString("database");
            var port = Integer.parseInt(rb.getString("port"));
            return String.format("%s:%d/%s", host, port, database);
        }
        catch (Exception e){
            log.error("Error getting the URL");
        }
       return null;
    }

    public String getUsername(){
        try {
            var rb = ResourceBundle.getBundle(rbName);
            return rb.getString("username");
        }
        catch (MissingResourceException e){
            log.error("Config file not found");
        }
        return null;
    }

    public String getPass(){
        try {
            var rb = ResourceBundle.getBundle(rbName);
            return rb.getString("password");
        }
        catch (Exception e){
            log.error("Error getting the password");
        }
        return null;
    }
}
