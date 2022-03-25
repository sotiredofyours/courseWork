package statements;

import lombok.extern.log4j.Log4j;

import java.sql.*;


@Log4j
public class StatementManager {

    public Statement createStatement(Connection connection){
        try{
            if (connection == null) throw new SQLException();
            var stmt = connection.createStatement();
            return stmt;
        } catch (SQLException e){
            log.error("Statement creation error");
        };
        return null;
    }


    public PreparedStatement createPreparedStatement(Connection connection, String sql)
    {
        try {
            if (sql == null || connection == null) throw new SQLException();
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            log.error("PreparedStatement creation error");
        }
        return null;
    }
}
