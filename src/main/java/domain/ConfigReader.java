package domain;

import java.util.ResourceBundle;

public class ConfigReader {

    private ResourceBundle rb;


    public ConfigReader(String baseName){
       try {
            rb = ResourceBundle.getBundle(baseName);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return;
    }

    public String getURL(){
        try{
        var host = rb.getString("host");
        var database = rb.getString("database");
        var port = Integer.parseInt(rb.getString("port"));
            return String.format("%s:%d/%s", host, port, database);}
        catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
    public String getUsername(){
        return rb.getString("username");
    }
    public String getPass(){
        return rb.getString("password");
    }
}
