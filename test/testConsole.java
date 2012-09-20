
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class testConsole {



    ConsoleControl console;
    ByteArrayOutputStream outputStream;


    @Before
    public void setUp() throws Exception {

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
     }

    @Test
    public void testWelcomeMessage()
     {
     //given
     TestInput testInput = new TestInput("");
      console = new ConsoleControl(testInput);
     //when
     console.init();
     //then
     assertThat(outputStream.toString(), is("Welcome to the wonderful library!\nWhat do you wish to do now?" +
             "Catalogue\n" +
             "Reserve Book\n" +
             "Enquire\n"));
     }

    @Test
    public void testMenuOptionCatalogue() throws Exception {
        //given
        TestInput testInput = new TestInput("Catalogue");
        console = new ConsoleControl(testInput);
        //when
        console.init();
        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("You are inside the catalogue!"));
    }


    @Test
    public void testMenuOptionEnquire() throws Exception {
        //given
        TestInput testInput = new TestInput("Enquire");
        console = new ConsoleControl(testInput);
        //when
        console.init();
        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Ask our helpful librarian"));
    }

    @Test
    public void testReserveABookAvailable(){
        //given
        TestInput testInput = new TestInput("Reserve Book\nDas Kapital");
        console = new ConsoleControl(testInput);
        //when
        console.init();
        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("Your book has been reserved"));
    }

    @Test
    public void testReserveABookUnavailable(){
        //given
        TestInput testInput = new TestInput("Reserve Book\nHunger Games");
        console = new ConsoleControl(testInput);
        //when
        console.init();
        console.readMenuInput();
        //then
        String[] actual = outputStream.toString().split("\n");
        assertTrue(actual[actual.length - 1].equals("We don't have that book yet"));
    }



}
