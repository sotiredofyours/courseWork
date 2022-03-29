package mapperbook;

import domain.Book;
import lombok.extern.log4j.Log4j;
import statements.StatementManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class MapperBook {

    public List<Book> getAllBooks(Connection con){
          var result = new ArrayList<Book>();
          if (con == null) return result;
          try(var stmt = con.createStatement()){
              try(var rs = stmt.executeQuery("SELECT * from Books")){
                  while(moveNextRS(rs)){
                      result.add(createBookFromRS(rs));
                  }
              }
          }
          catch (SQLException e) {
              log.error("Getting all books error");
              return null;
         }
          return result;
    }

     public Book createBookFromRS(ResultSet rs) {
        try {
            return Book.builder()
                    .id(rs.getInt(1))
                    .title(rs.getString(2))
                    .author(rs.getString(3))
                    .quantity(rs.getInt(4))
                    .build();
        }
        catch (SQLException e){
            log.error("Book creation error");
        }
          return null;
     }

     boolean moveNextRS(ResultSet rs) throws SQLException {
      if (rs != null)
          return rs.next();
      return false;
     }

     public Book getBookById(Integer ID, Connection con){
        if (con == null) return null;
          try(var pstmt = new StatementManager().
                  createPreparedStatement(con, "Select * from books where id = ?")){
               pstmt.setInt(1, ID);
             try(var rs =  pstmt.executeQuery()) {
                  if (moveNextRS(rs)) {
                       return createBookFromRS(rs);
                  }
                  else log.error("Book with this id does`t exist");
             }
          }
          catch (SQLException s){
               log.error("Getting book by id error");
          }
          return null;
     }

     public Book getBookByAuthor(String author, Connection con){
          try(var pstmt = new StatementManager().
                  createPreparedStatement(con, "Select * from books where author = ?")){
               pstmt.setString(1, author);
               try(var rs =  pstmt.executeQuery()) {
                    if (moveNextRS(rs)) {
                         return createBookFromRS(rs);
                    }
                    else log.error("Book with this id does`t exist");
               }
          }
          catch (SQLException s){
               log.error("Getting book by id error");
          }
          return null;
     }
}
