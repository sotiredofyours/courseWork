package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;

@Setter
@Getter
public class Book {
     Integer id;
     String title;
     String author;
     Integer quantity;
     public void getInfoFromDB() throws SQLException {
          var con = new ConnectionManager().getConnection("DBconfig");
          var stmt = new StatementManager().createStatement(con);
          var rs = stmt.executeQuery("SELECT * from Books");
          while (rs.next()){
               id = rs.getInt(1);
               title = rs.getString(2);
               author = rs.getString(3);
               quantity = rs.getInt(4);
          }
     }
}
