import connection.ConnectionManager;
import mapperbook.MapperBook;
import org.junit.Assert;
import org.junit.Test;
import resultsets.RSManager;
import statements.StatementManager;

import java.util.Optional;

public class MapperBookTest {

    @Test
    public void TestWithNormalRS(){
        double d = 1;
        var con = new ConnectionManager().getConnection("dbconfig");
        var stmt = new StatementManager().createStatement(con);
        var rs = new RSManager().executeSql(stmt, "Select * from books");
        var res = new MapperBook().createBookFromRS(rs);
        Assert.assertEquals("Leo Tolstoy", res.get(0).getAuthor());
        Assert.assertEquals(Optional.of(1), Optional.ofNullable((Integer) res.get(0).getId()));
    }

    @Test
    public void TestWithWrongRS(){
        var res = new MapperBook().createBookFromRS(null);
        Assert.assertNull(res);
    }
}
