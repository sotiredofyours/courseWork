import lombok.extern.log4j.Log4j;
import mapperbook.MapperBook;
import statements.StatementManager;
import connection.ConnectionManager;
import java.sql.SQLException;

@Log4j
public class Application {
    public static void main(String[] args) {
        var cm = new ConnectionManager();
        var con = cm.getConnection("dbconfig");
        var sm = new StatementManager();
        var book = new MapperBook().getAllBooks(con);
    }
}
