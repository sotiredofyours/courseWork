package Statements;

import lombok.extern.log4j.Log4j;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


@Log4j
public class StatementManager {

    public Statement createStatement(Connection connection){
        try{
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
        var pstmt = connection.prepareStatement(sql);
            return pstmt;
        } catch (SQLException e) {
            log.error("PreparedStatement creation error");
        }
        return null;
    }
}
