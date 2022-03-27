package databaseconfig;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.ResourceBundle;

@Getter
@Log4j
public class ConfigReader {

    private String rbName;
    private String URL;
    private String Password;
    private String Username;

    public ConfigReader(String baseName) {
        rbName = baseName;
        Init();
    }

    private void Init() {
        try {
            URL = doURL();
            var rb = ResourceBundle.getBundle(rbName);
            Password = rb.getString("password");
            Username = rb.getString("username");
        }
        catch (Exception e) {
            log.error("ConfigReader error");
        }
    }

    private String doURL() {
        try {
            var rb = ResourceBundle.getBundle(rbName);
            var host = rb.getString("host");
            var database = rb.getString("database");
            var port = Integer.parseInt(rb.getString("port"));
            return String.format("%s:%d/%s", host, port, database);
        } catch (Exception e) {
            log.error("Error getting the URL");
        }
        return null;
    }
}
