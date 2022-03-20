import dataBaseConfig.ConfigReader;
import org.junit.Assert;
import org.junit.Test;

public class ConfigReaderTest {

    @Test
    public void constructorTest(){
        var cr = new ConfigReader("testDB");
        Assert.assertNotNull(cr);
    }


    @Test
    public void wrongConstructorTest(){
        var cr = new ConfigReader("ds");
    }



}
