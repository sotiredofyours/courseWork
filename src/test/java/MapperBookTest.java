import connection.ConnectionManager;
import mapperbook.MapperBook;
import org.junit.Assert;
import org.junit.Test;

public class MapperBookTest {

    @Test
    public void gettingBookById(){
        var con = new ConnectionManager().getConnection("dbconfig");
        var book = new MapperBook().getBookById(1, con);
        Assert.assertEquals("Leo Tolstoy", book.getAuthor());
        Assert.assertEquals("Peace and War", book.getTitle());
        Assert.assertNull(new MapperBook().getBookById(1,null));
        Assert.assertNull(new MapperBook().getBookById(2312,null));
    }

    @Test
    public void gettingAllBooks(){
        var con = new ConnectionManager().getConnection("dbconfig");
        var books = new MapperBook().getAllBooks(con);
        Assert.assertEquals(2, books.size());
        books = new MapperBook().getAllBooks(null);
        Assert.assertEquals(0, books.size());
    }

    @Test
    public void gettingBookByAuthor(){
        var con = new ConnectionManager().getConnection("dbconfig");
        var book = new MapperBook().getBookByAuthor("Leo Tolstoy", con);
        Assert.assertEquals("Peace and War", book.getTitle());
    }



}
