import ResultSets.RSManager;
import Statements.StatementManager;
import connection.ConnectionManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        var cm = new ConnectionManager();
        var con = cm.getConnection("dbconfig");
        var sm = new StatementManager();
        var rs =  new RSManager();
        var kek = rs.executeSql(sm.createStatement(con), "Select * from books");
        rs.printResultSet(kek);
    }
}
