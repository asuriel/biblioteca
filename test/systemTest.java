import org.junit.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class systemTest {

    Catalogue cat = new Catalogue();
    Book booka = new Book("Game of Thrones", "available");
    Book bookb = new Book("Great Expectations", "available");
    cat.add(booka);
    cat.add(bookb)
   // HashMap<String,Book> books = new HashMap<String,Book>();
    //books.put(booka);
    //books.put(bookb);

    @Test
  public void testCatalogueDisplaysAllBooks()
  {
   //given
      ArrayList<Book> expected = new ArrayList<Book>();
      expected.add(booka);
      expected.add(bookb);
   //when
      ArrayList<Book> actual = cat.displayAllBooks();
   //then
      assertTrue(expected.containsAll(actual));
  }

  @Test
  public void testUserCannotReserveUnavailableBook()
  {
      //given
      Book bookUnavailable = new Book("Das Kapital","unavailable");
      cat.add(bookUnavailable);
      //when
      Boolean response = cat.reserve(bookUnavailable);
      //then
      assertThat(response, is(false)) ;
  }
   @Test
   public void testUserCanReserveAvailableBook()
   {
       //given
       Book bookAvailable = new Book("PhD Thesis","available");
       cat.add(bookAvailable);
       //when
       Boolean response = cat.reserve(bookAvailable);
       //then
       assertTrue(response);
   }
}
