
import org.junit.Before;
import org.junit.Ignore;
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

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        librarian = new Librarian();
        console = new Console();

     }

    @Test
    public void testWelcomeMessage()
     {
     //given
     TestInput testInput = new TestInput("");

     //when
     console.init(testInput,librarian);

     //then
     assertThat(outputStream.toString(), is("Welcome to the wonderful library!\nWhat do you wish to do now?\n" +
             "Catalogue\n" +
             "Reserve Item\n" +
             "Enquire\n"));
     }

    @Test
    public void testMenuOptionCatalogue() throws Exception {

        //given
        TestInput testInput = new TestInput("Catalogue");

        Item example = new Item("Das Kapital");
        librarian.addBook("1",example); //we have now one book in the catalogue

        //when
        console.init(testInput,librarian);
        console.readMenuInput();

        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Das Kapital;"));
    }


    @Test
    public void testMenuOptionEnquire() throws Exception {
        //given
        TestInput testInput = new TestInput("Enquire");

        //when
        console.init(testInput,librarian);
        console.readMenuInput();

        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Ask our helpful librarian"));
    }


    @Test
    @Ignore
    public void testReserveABookAvailable(){
        //given
        TestInput testInput = new TestInput("Reserve Item\nDas Kapital");

        //when
        console.init(testInput,librarian);

        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Your book has been reserved"));
    }

    @Test
    @Ignore
    public void testReserveABookUnavailable(){
        //given
        TestInput testInput = new TestInput("Reserve Item\nHunger Games");

        //when
        console.init(testInput,librarian);
        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("We don't have that book yet"));
    }


}
