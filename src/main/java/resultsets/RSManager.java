package resultsets;

import lombok.extern.log4j.Log4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j
public class RSManager {

    public ResultSet executeSql(Statement statement, String sql){
        try {
            return  statement.executeQuery(sql);
        } catch (SQLException e) {
            log.error("Execute query error");
        }
        return null;
    }

    public void printResultSet(ResultSet rs){
        int columns = 0;
        try {
            columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                StringBuilder str = new StringBuilder();
                for (int i = 1; i <= columns; i++)
                    str.append(rs.getString(i) + "\t");
                System.out.println(str);
            }

            rs.close();
        }
        catch (SQLException e) {
            log.error("Print ResultSet error");
        }
    }



}
