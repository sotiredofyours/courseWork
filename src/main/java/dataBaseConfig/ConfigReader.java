package dataBaseConfig;

import lombok.extern.log4j.Log4j;
import java.util.ResourceBundle;

@Log4j
public class ConfigReader {

    private final String rbName;

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
        catch (Exception e){
            log.error("Error getting the username");
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
