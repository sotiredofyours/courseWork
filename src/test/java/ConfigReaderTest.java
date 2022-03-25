import databaseconfig.ConfigReader;
import org.junit.Assert;
import org.junit.Test;

public class ConfigReaderTest {

    @Test
    public void constructorTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertNotNull(cr);

    }

    @Test
    public void getUrlTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertEquals("host=jdbc:postgresql://localhost:5432/test", cr.getURL());
        cr.setRbName("123");
        Assert.assertNull(cr.getURL());
    }

    @Test
    public void getUsernameTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertEquals("postgres", cr.getUsername());
        cr.setRbName("123");
        Assert.assertNull(cr.getUsername());
        cr.setRbName("wrongtestdb");
        Assert.assertNull(cr.getUsername());
    }

    @Test
    public void getPasswordTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertEquals("admin213", cr.getPass());
        cr.setRbName("123");
        Assert.assertNull(cr.getUsername());
        cr.setRbName("wrongtestdb");
        Assert.assertNull(cr.getUsername());
    }







}
