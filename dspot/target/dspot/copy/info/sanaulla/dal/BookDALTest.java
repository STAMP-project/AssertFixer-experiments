package info.sanaulla.dal;


import info.sanaulla.models.Book;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;


public class BookDALTest {
    private static BookDAL mockedBookDAL;

    private static Book book1;

    private static Book book2;

    @BeforeClass
    public static void setUp() {
        BookDALTest.mockedBookDAL = Mockito.mock(BookDAL.class);
        BookDALTest.book1 = new Book("8131721019", "Compilers Principles", Arrays.asList("D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"), "Pearson Education Singapore Pte Ltd", 2008, 1009, "BOOK_IMAGE");
        BookDALTest.book2 = new Book("9788183331630", "Let Us C 13th Edition", Arrays.asList("Yashavant Kanetkar"), "BPB PUBLICATIONS", 2012, 675, "BOOK_IMAGE");
        Mockito.when(BookDALTest.mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(BookDALTest.book1, BookDALTest.book2));
        Mockito.when(BookDALTest.mockedBookDAL.getBook("8131721019")).thenReturn(BookDALTest.book1);
        Mockito.when(BookDALTest.mockedBookDAL.addBook(BookDALTest.book1)).thenReturn(BookDALTest.book1.getIsbn());
        Mockito.when(BookDALTest.mockedBookDAL.updateBook(BookDALTest.book1)).thenReturn(BookDALTest.book1.getIsbn());
    }

    @Test(timeout = 10000)
    public void testGetBook_sd1() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd1__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd1__4);
        String o_testGetBook_sd1__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd1__5);
        int o_testGetBook_sd1__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd1__6)));
        String o_testGetBook_sd1__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd1__8);
        Integer o_testGetBook_sd1__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd1__9)));
        Integer o_testGetBook_sd1__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd1__10)));
        List<String> o_testGetBook_sd1__11 = myBook.getAuthors();
        Assert.assertTrue(o_testGetBook_sd1__11.contains("D. Jeffrey Ulman"));
        Assert.assertTrue(o_testGetBook_sd1__11.contains("Ravi Sethi"));
        Assert.assertTrue(o_testGetBook_sd1__11.contains("Alfred V. Aho"));
        Assert.assertTrue(o_testGetBook_sd1__11.contains("Monica S. Lam"));
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals("8131721019", o_testGetBook_sd1__4);
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd1__9)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd1__8);
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd1__5);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd1__10)));
        Assert.assertEquals(4, ((int) (o_testGetBook_sd1__6)));
    }

    @Test(timeout = 10000)
    public void testGetBook_sd2() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd2__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd2__4);
        String o_testGetBook_sd2__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd2__5);
        int o_testGetBook_sd2__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd2__6)));
        String o_testGetBook_sd2__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd2__8);
        Integer o_testGetBook_sd2__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd2__9)));
        Integer o_testGetBook_sd2__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd2__10)));
        String o_testGetBook_sd2__11 = myBook.getImage();
        Assert.assertEquals("BOOK_IMAGE", o_testGetBook_sd2__11);
        Assert.assertEquals("8131721019", o_testGetBook_sd2__4);
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals(4, ((int) (o_testGetBook_sd2__6)));
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd2__10)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd2__8);
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd2__5);
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd2__9)));
    }

    @Test(timeout = 10000)
    public void testGetBook_sd3() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd3__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd3__4);
        String o_testGetBook_sd3__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd3__5);
        int o_testGetBook_sd3__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd3__6)));
        String o_testGetBook_sd3__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd3__8);
        Integer o_testGetBook_sd3__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd3__9)));
        Integer o_testGetBook_sd3__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd3__10)));
        String o_testGetBook_sd3__11 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd3__11);
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd3__5);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd3__10)));
        Assert.assertEquals("8131721019", o_testGetBook_sd3__4);
        Assert.assertEquals(4, ((int) (o_testGetBook_sd3__6)));
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd3__9)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd3__8);
        Assert.assertEquals("8131721019", isbn);
    }

    @Test(timeout = 10000)
    public void testGetBook_sd4() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd4__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd4__4);
        String o_testGetBook_sd4__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd4__5);
        int o_testGetBook_sd4__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd4__6)));
        String o_testGetBook_sd4__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd4__8);
        Integer o_testGetBook_sd4__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd4__9)));
        Integer o_testGetBook_sd4__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd4__10)));
        Integer o_testGetBook_sd4__11 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd4__11)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd4__8);
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd4__5);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd4__10)));
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals("8131721019", o_testGetBook_sd4__4);
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd4__9)));
        Assert.assertEquals(4, ((int) (o_testGetBook_sd4__6)));
    }

    @Test(timeout = 10000)
    public void testGetBook_sd5() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd5__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd5__4);
        String o_testGetBook_sd5__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd5__5);
        int o_testGetBook_sd5__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd5__6)));
        String o_testGetBook_sd5__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd5__8);
        Integer o_testGetBook_sd5__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd5__9)));
        Integer o_testGetBook_sd5__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd5__10)));
        String o_testGetBook_sd5__11 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd5__11);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd5__10)));
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd5__5);
        Assert.assertEquals(4, ((int) (o_testGetBook_sd5__6)));
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals("8131721019", o_testGetBook_sd5__4);
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd5__9)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd5__8);
    }

    @Test(timeout = 10000)
    public void testGetBook_sd6() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd6__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd6__4);
        String o_testGetBook_sd6__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd6__5);
        int o_testGetBook_sd6__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd6__6)));
        String o_testGetBook_sd6__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd6__8);
        Integer o_testGetBook_sd6__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd6__9)));
        Integer o_testGetBook_sd6__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd6__10)));
        String o_testGetBook_sd6__11 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd6__11);
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals("8131721019", o_testGetBook_sd6__4);
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd6__8);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd6__10)));
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd6__9)));
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd6__5);
        Assert.assertEquals(4, ((int) (o_testGetBook_sd6__6)));
    }

    @Test(timeout = 10000)
    public void testGetBook_sd7() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd7__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd7__4);
        String o_testGetBook_sd7__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd7__5);
        int o_testGetBook_sd7__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd7__6)));
        String o_testGetBook_sd7__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd7__8);
        Integer o_testGetBook_sd7__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd7__9)));
        Integer o_testGetBook_sd7__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd7__10)));
        Integer o_testGetBook_sd7__11 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd7__11)));
        Assert.assertEquals("8131721019", isbn);
        Assert.assertEquals("8131721019", o_testGetBook_sd7__4);
        Assert.assertEquals(4, ((int) (o_testGetBook_sd7__6)));
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd7__5);
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd7__8);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd7__10)));
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd7__9)));
    }

    @Test(timeout = 10000)
    public void testGetBook_sd8() throws Exception {
        String isbn = "8131721019";
        Assert.assertEquals("8131721019", isbn);
        Book myBook = BookDALTest.mockedBookDAL.getBook(isbn);
        String o_testGetBook_sd8__4 = myBook.getIsbn();
        Assert.assertEquals("8131721019", o_testGetBook_sd8__4);
        String o_testGetBook_sd8__5 = myBook.getTitle();
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd8__5);
        int o_testGetBook_sd8__6 = myBook.getAuthors().size();
        Assert.assertEquals(4, ((int) (o_testGetBook_sd8__6)));
        String o_testGetBook_sd8__8 = myBook.getPublication();
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd8__8);
        Integer o_testGetBook_sd8__9 = myBook.getYearOfPublication();
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd8__9)));
        Integer o_testGetBook_sd8__10 = myBook.getNumberOfPages();
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd8__10)));
        String o_testGetBook_sd8__11 = myBook.method();
        Assert.assertEquals("method", o_testGetBook_sd8__11);
        Assert.assertEquals("Compilers Principles", o_testGetBook_sd8__5);
        Assert.assertEquals(2008, ((int) (o_testGetBook_sd8__9)));
        Assert.assertEquals("8131721019", o_testGetBook_sd8__4);
        Assert.assertEquals(1009, ((int) (o_testGetBook_sd8__10)));
        Assert.assertEquals(4, ((int) (o_testGetBook_sd8__6)));
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", o_testGetBook_sd8__8);
        Assert.assertEquals("8131721019", isbn);
    }
}

