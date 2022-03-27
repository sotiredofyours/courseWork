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
        var testCR2 = new ConfigReader("123");
        Assert.assertNull(testCR2.getURL());
    }

    @Test
    public void getUsernameTest(){
        var testCR = new ConfigReader("testDB");
        Assert.assertEquals("postgres", testCR.getUsername());
        var testCR2 = new ConfigReader("123");
        Assert.assertNull(testCR2.getUsername());
        var testCR3 = new ConfigReader("wrongtestdb");
        Assert.assertNull(testCR3.getUsername());
    }

    @Test
    public void getPasswordTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertEquals("admin213", cr.getPassword());
        var testCR2 = new ConfigReader("123");
        Assert.assertNull(testCR2.getUsername());
        var testCR3 = new ConfigReader("wrongtestdb");
        Assert.assertNull(testCR3.getUsername());
    }







}
