import domain.ConfigReader;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class ConfigReaderTest {

    @Test
    public void constructorTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertNotNull(cr);
    }

    //TODO
    @Test
    public void wrongConstructorTest(){
        var cr = new ConfigReader("ds");
    }

    @Test
    public void getUrl(){
        var cr = new ConfigReader("DBConfig");
        var res = cr.getURL();
        var expected = "jdbc:postgresql://localhost:5432/test";
        Assert.assertEquals(expected, res);
    }

    @Test
    public void getTestUrl(){
        var cr = new ConfigReader("testDB");
        var res = cr.getURL();
        var expected = "jdbc:postgresql://localhost:5432/";
        Assert.assertEquals(expected, res);
    }

}
