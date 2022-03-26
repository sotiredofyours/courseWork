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
     public List<Book> createBookFromRS(ResultSet rs){
          var result = new ArrayList<Book>();
          try
          {
               if (rs == null) throw new SQLException();
               while (rs.next()){
                    Book book = Book.builder().id(rs.getInt(1))
                            .title(rs.getString(2))
                            .author(rs.getString(3))
                            .quantity(rs.getInt(4))
                            .build();
                    result.add(book);
               }
          } catch (SQLException e) {
               log.error("Making book error");
               return null;
          }
          return result;
     }

     public Book GetBookById(Integer ID, Connection con){
          try(var pstmt = new StatementManager().
                  createPreparedStatement(con, "Select * from book where id = ?")){
               pstmt.setInt(1, ID);
             try(var rs =  pstmt.executeQuery()) {
                  if (rs != null) {
                       rs.next();
                       return Book.builder()
                               .id(rs.getInt(1))
                               .title(rs.getString(2))
                               .author(rs.getString(3))
                               .quantity(rs.getInt(4))
                               .build();
                  }
                  else log.error("Book with this id does`t exist");
             }
          }
          catch (SQLException s){
               log.error("Getting book by id error");
          }
          return null;
     }

     public Book GetBookByAuthor(String author, Connection con){
          try(var pstmt = new StatementManager().
                  createPreparedStatement(con, "Select * from book where id = ?")){
               pstmt.setString(3, author);
               try(var rs =  pstmt.executeQuery()) {
                    if (rs != null) {
                         rs.next();
                         return Book.builder()
                                 .id(rs.getInt(1))
                                 .title(rs.getString(2))
                                 .author(rs.getString(3))
                                 .quantity(rs.getInt(4))
                                 .build();
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
