package mapperbook;

import domain.Book;
import lombok.extern.log4j.Log4j;

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
}
