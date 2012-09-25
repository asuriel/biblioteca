import java.io.*;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private Librarian librarian;

    public Console(){
    }

    public void init(InputStream in, Librarian librarian) {

        scanner = new Scanner(in);
        this.librarian = librarian;

        System.out.println("Welcome to the wonderful library!\nWhat do you wish to do now?\n" +
                "Catalogue\n" +
                "Reserve Item\n" +
                "Enquire");
     }

     public String readLine()
     {
         String line = scanner.nextLine();

         if(line.equals("exit"))
             {
                 return("bye!");
             }
          return line;
      }

    public void readMenuInput() {


            while(scanner.hasNext())
            {
                String option = scanner.nextLine();

                if(option.equals("Catalogue"))
                {
                    displayAllBooks();
                    readMenuInput();
                }
                else if(option.equals("Reserve Item"))
                {
                    System.out.println("Choose the book to reserve");
                    String book = scanner.nextLine();
                    System.out.println(reserveBook(book));
                    readMenuInput();
                }
                else if(option.equals("Enquire"))
                {
                    System.out.println("Ask our helpful librarian");
                    readMenuInput();
                }
                else if(option.equals("exit"))
                {
                    //flag = false;
                    System.out.println("bye bye!");
                }

                else
                {
                    System.out.println("Select a valid option!!");
                    readMenuInput();
                }
            }
 }

    public String reserveBook(String title)
    {
        Item book = librarian.findByTitle(title);//enquire the db

        if(book != null)
        {
            if(librarian.reserve(book))
            {
                return ("Your book has been reserved");
            }
            return ("The book is on loan");
        }
        return ("We don't have that book yet");

    }
    public void displayAllBooks()
    {
        for(Item b: librarian.displayAll())
        {
            System.out.print(b.displayTitle() + ";");
        }
    }

}
