package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RSManager {

    public void printResultSet(ResultSet rs){
        StringBuilder str = new StringBuilder();
        int columns = 0;
        try {
            columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    str.append(rs.getString(i) + "\t");
                }
            }
            rs.close();
        }
        catch (SQLException e) {
        }
    }

}
