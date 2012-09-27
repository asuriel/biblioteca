import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class testConsole {

    Console console;
    ByteArrayOutputStream outputStream;
    Librarian librarian;


    @Before
    public void setUp() throws Exception {

        ServiceLocator.load(new ServiceLocator(new TextCatalogue()));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        librarian = new Librarian();
        console = new Console();

    }

    @Test
    public void testWelcomeMessage() {
        //given
        TestInput testInput = new TestInput("");

        //when
        console.init(testInput, librarian);

        //then
        assertThat(outputStream.toString(), is("Welcome to the wonderful library!\nWhat do you wish to do now?\n" +
                "Catalogue\n" +
                "Reserve Item\n" +
                "Enquire\n"));
    }

    @Test
    public void testMenuOptionCatalogue() throws Exception {

        //given
        TestInput testInput = new TestInput("Catalogue\nMovies");

        //when
        console.init(testInput, librarian);
        console.assignLibraryAccion();

        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("DogVille  2002  Lars Von Trier  5  Available"));//last item in the catalogue
    }


    @Test
    public void testMenuOptionEnquire() throws Exception {
        //given
        TestInput testInput = new TestInput("Enquire");

        //when
        console.init(testInput, librarian);
        console.assignLibraryAccion();

        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Ask our helpful librarian"));
    }


    @Test
    public void testReserveABookAvailable() {
        //given
        Item example = new Item("Das Kapital");
        librarian.addItem("1", example); //we have now one book in the catalogue

        TestInput testInput = new TestInput("Reserve Item\nDas Kapital");

        //when
        console.init(testInput, librarian);

        console.assignLibraryAccion();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Your item has been reserved"));
    }

    @Test
    public void testReserveABookUnavailable() {
        //given
        TestInput testInput = new TestInput("Reserve Item\nHunger Games");

        //when
        console.init(testInput, librarian);
        console.assignLibraryAccion();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("We don't have that item yet"));
    }

    @Test
    public void testTryToReserveBookTwice() {
        //given
        TestInput testInput = new TestInput("Reserve Item\nBatman\nReserve Item\nBatman");

        //when
        console.init(testInput, librarian);
        console.assignLibraryAccion();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("The item is on loan"));
    }


}
