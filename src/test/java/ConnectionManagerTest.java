import connection.ConnectionManager;
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

    @Test
    public void correctURLfromProp(){
        ConnectionManager cm = new ConnectionManager();
        var res = cm.getConnection("DBConfig");
    }

    @Test
    public void wrongUrlfromProp(){
        ConnectionManager cm = new ConnectionManager();
        var res = cm.getConnection("testDB");
        Assert.assertNull(res);
    }
}
