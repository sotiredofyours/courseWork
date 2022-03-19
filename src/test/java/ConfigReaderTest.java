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



}
