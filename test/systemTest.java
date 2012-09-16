
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class systemTest {

    Cataloguer cat = new Cataloguer();
    Book aBook = new Book();
    Book bBook = new Book();

   @Test
  public void testCatalogueDisplaysAllBooks()
  {
   //given
      cat.addBook("codeForBookA",aBook);
      cat.addBook("codeForBookB",bBook);

      ArrayList<Book> expected = new ArrayList<Book>();
      expected.add(aBook);
      expected.add(bBook);
   //when
      ArrayList<Book> actual = cat.displayAll();
   //then
      assertTrue(expected.containsAll(actual));
  }

  @Test
  public void testUserCannotReserveUnavailableBook()
  {
      //given
      Book bookUnavailable = new Book();
      cat.addBook("unavailableBookCode",bookUnavailable);
      Boolean firstTry = cat.reserve(bookUnavailable);
      //when
      Boolean secondTry = cat.reserve(bookUnavailable);
      //then
      assertThat(secondTry, is(false)) ;
  }
   @Test
   public void testUserCanReserveAvailableBook()
   {
       //given
       Book bookAvailable = new Book();
       //when
       Boolean response = cat.reserve(bookAvailable);
       //then
       assertTrue(response);
   }
}
