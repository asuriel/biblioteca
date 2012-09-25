
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class systemTest {

    Librarian librarian = new Librarian();
    Item aBook = new Item();
    Item bBook = new Item();

    @Before
    public void configureForTextCatalogue()
    {
        ServiceLocator.load(new ServiceLocator(new TextCatalogue()));
    }

   @Test
  public void testCatalogueDisplaysAllBooks()
  {
   //given
      librarian.addItem("codeForBookA", aBook);
      librarian.addItem("codeForBookB", bBook);

      ArrayList<Item> expected = new ArrayList<Item>();
      expected.add(aBook);
      expected.add(bBook);
   //when
      ArrayList<Item> actual = librarian.displayAll();
   //then
      assertTrue(expected.containsAll(actual));
  }

  @Test
  public void testUserCannotReserveUnavailableBook()
  {
      //given
      Item bookUnavailable = new Item();
      librarian.addItem("unavailableBookCode", bookUnavailable);
      Boolean firstTry = librarian.reserve(bookUnavailable);
      //when
      Boolean secondTry = librarian.reserve(bookUnavailable);
      //then
      assertThat(secondTry, is(false)) ;
  }
   @Test
   public void testUserCanReserveAvailableBook()
   {
       //given
       Item bookAvailable = new Item();
       //when
       Boolean response = librarian.reserve(bookAvailable);
       //then
       assertTrue(response);
   }
}
