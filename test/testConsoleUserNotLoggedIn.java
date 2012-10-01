import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class testConsoleUserNotLoggedIn {

    Controler controler;
    ByteArrayOutputStream outputStream;
    Librarian librarian;


    @Before
    public void setUp() throws Exception {

        ServiceLocator.load(new ServiceLocator(new TextCatalogue()));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        librarian = new Librarian();
        controler = new Controler();

    }

    @Test
    public void testWelcomeMessage() {
        //given
        TestInput testInput = new TestInput("");

        //when
        controler.init(testInput, librarian);

        //then
        assertThat(outputStream.toString(), is("Welcome to the wonderful Biblioteca!\nWhat do you wish to do now?\n\n\n" + "Catalogue\n" +
                "Reserve Item\n" +
                "Enquire\n"+
                "Login\n"));
    }


    @Test
    public void testMenuOptionCatalogue() throws Exception {

        //given
        TestInput testInput = new TestInput("Catalogue\nMovies");

        //when
        Movie testMovie = new Movie("DogVille", "2002", "Lars Von Trier", "5");
        librarian.addItem("1",testMovie);
        controler.init(testInput, librarian);
        controler.assignLibraryAccion();

        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("DogVille  2002  Lars Von Trier  5  Available"));//last item in the catalogue
    }


    @Test
    public void testMenuOptionEnquireNotLoggedIn() throws Exception {
        //given
        TestInput testInput = new TestInput("Enquire");

        //when
        controler.init(testInput, librarian);
        controler.assignLibraryAccion();

        //then
        String actual = outputStream.toString();
        assertTrue(actual.contains("Ask the librarian\n"));
    }


   @Test
    public void testReserveABookAvailable() {
        //given
        Item example = new Item("Das Kapital");
        librarian.addItem("1", example); //we have now one book in the catalogue

        TestInput testInput = new TestInput("Reserve Item\nDas Kapital");

        //when
        controler.init(testInput, librarian);

        controler.assignLibraryAccion();
        //then
        String actual = outputStream.toString();
        assertTrue(actual.contains("In order to reserve this item you need to login\n"));
    }



}
