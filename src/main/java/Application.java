import lombok.extern.log4j.Log4j;
import mapperbook.MapperBook;
import resultsets.RSManager;
import statements.StatementManager;
import connection.ConnectionManager;
import java.sql.SQLException;

@Log4j
public class Application {
    public static void main(String[] args) throws SQLException {
        var cm = new ConnectionManager();
        var con = cm.getConnection("dbconfig");
        var sm = new StatementManager();
        var rm =  new RSManager();
        var book = new MapperBook().getAllBooks(con);
    }
}
