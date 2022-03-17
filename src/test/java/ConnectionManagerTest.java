import domain.ConnectionManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ConnectionManagerTest {

    @Test
    public void wrongURL() throws Exception{
        ConnectionManager cm = new ConnectionManager();
        var res =  cm.getConnection("S", "dsa", "1");
        Assert.assertNull(res);
    }

    @Test
    public void correctURL(){
        ConnectionManager cm = new ConnectionManager();
        var res =  cm.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "admin");
        Assert.assertNotNull(res);
    }
}
