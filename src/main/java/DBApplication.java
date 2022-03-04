import org.apache.log4j.Logger;

import java.sql.*;


public class DBApplication {
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String username = "postgres";
    private static final String pass = "admin";
    final static Logger log = Logger.getLogger(DBApplication.class);

    public static Connection getConnection(String URL, String username, String pass){
        try {
            Connection con = DriverManager.getConnection(URL, username, pass);
            if (con != null) {
                return con;
            }
        } catch (SQLException e) {
            log.debug("Failed connection");
        }
        return null;
    }

    public static void Disconnect(Connection connection){
        try {
            connection.close();
            connection = null;
        }
        catch (Exception e) {}
    }

    public static ResultSet execSql( Statement stmt, String sql){
        try {
            var result = stmt.executeQuery(sql);
            return  result;
        } catch (SQLException e) {
            log.debug("SQL query error");
        }
        return null;
    }

    public static Statement createStatement(Connection connection){
        try {
            var stmt = connection.createStatement();
            return stmt;
        } catch (SQLException e) {
            log.debug("Statement create error");
        }
        return null;
    }
    //TODO: preparedStatement

    public static void printResultSet(ResultSet rs){
        StringBuilder str = new StringBuilder();
        int columns = 0;
        try {
            columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    str.append(rs.getString(i) + "\t");

                }
                log.debug(str);
            }
            rs.close();
        }
        catch (SQLException e) {
                log.debug("print RS error");
            }
    }

    public static PreparedStatement createPreparedStatement(Connection connection){
        return null;
    }


    public static void main(String[] args) {
        var con = getConnection(URL, username, pass);
        if (con != null){
            var stmt = createStatement(con);
            var rs = execSql(stmt, "Select * from Books");
            printResultSet(rs);
        }
        Disconnect(con);

    }
}
