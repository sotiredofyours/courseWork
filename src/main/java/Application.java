import mapperbook.MapperBook;
import resultsets.RSManager;
import statements.StatementManager;
import connection.ConnectionManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        var cm = new ConnectionManager();
        var con = cm.getConnection("dbconfig");
        var sm = new StatementManager();
        var rs =  new RSManager();
        var kek = rs.executeSql(sm.createStatement(con), "Select * from books");
        var res = new MapperBook().createBookFromRS(kek);
        System.out.println(res.get(0).getAuthor());
    }
}
