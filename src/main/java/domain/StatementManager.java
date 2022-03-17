package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementManager {


    public Statement createStatement(Connection connection){
        try(var stmt = connection.createStatement()){
            return stmt;
        } catch (SQLException e){};
        return null;
    }
    public PreparedStatement createPreparedStatement(Connection connection, String sql)
    {
        try(var pstmt = connection.prepareStatement(sql)) {
            return pstmt;
        } catch (SQLException e) {}
        return null;
    }
}
