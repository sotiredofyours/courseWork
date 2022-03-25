import Statements.StatementManager;
import connection.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

public class StatementManagerTest {

    @Test
    public void createStatementWithRightConnection(){
        var con = new ConnectionManager().getConnection("dbconfig");
        var sm = new StatementManager();
        var res = sm.createStatement(con);
        Assert.assertNotNull(res);
    }

    @Test
    public void createStatementWithWrongConnection(){
        var sm = new StatementManager();
        var res = sm.createStatement(null);
        Assert.assertNull(res);
    }

    @Test
    public void createPreparedStatementWithRightConnection(){
        var con = new ConnectionManager().getConnection("dbconfig");
        var sm = new StatementManager();
        var res = sm.createPreparedStatement(con, "null");
        Assert.assertNotNull(res);
    }
}
