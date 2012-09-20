import java.io.*;
import java.util.Scanner;

public class ConsoleControl {


    private Scanner scanner;

    public ConsoleControl(InputStream in){

     //System.setIn(in);
     //System.setOut(out);

        scanner = new Scanner(in);
    }

    public void init() {

        System.out.println("Welcome to the wonderful library!\nWhat do you wish to do now?" +
                "Catalogue\n" +
                "Reserve Book\n" +
                "Enquire");
     }
    /**
     public void start()
     {
        readInput(scanner.nextLine());
     }
     */
    public void readMenuInput() {

        String option = scanner.nextLine();

        if(option.equals("Catalogue"))
        {
            System.out.println("You are inside the catalogue!");
        }
        else if(option.equals("Reserve Book"))
        {
            System.out.println("Choose the book to reserve");
        }
        else if(option.equals("Enquire"))
        {
            System.out.println("Ask our helpful librarian");
        }
        else
        {
            System.out.println("Select a valid option!!");
        }
    }

}
