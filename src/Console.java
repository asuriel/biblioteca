import java.io.*;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private Librarian librarian;

    public Console() {
    }

    public void init(InputStream in, Librarian librarian) {

        scanner = new Scanner(in);
        this.librarian = librarian;
        librarian.loadLibrary();

        System.out.println("Welcome to the wonderful Biblioteca!\nWhat do you wish to do now?\n\n\n" +
                "Catalogue\n" +
                "Reserve Item\n" +
                "Enquire");
    }

    public String readLine() {
        String line = scanner.nextLine();

        if (line.equals("exit")) {
            return ("bye!");
        }
        return line;
    }

    public void readMenuInput() {


        while (scanner.hasNext()) {
            String option = scanner.nextLine();

            if (option.equals("Catalogue")) {
                System.out.println("Movies");
                if (scanner.nextLine().equals("Movies")) {
                    displayAllItems();
                }
                readMenuInput();
            } else if (option.equals("Reserve Item")) {
                System.out.println("Choose the book to reserve");
                String bookTitle = scanner.nextLine();
                System.out.println(reserveBook(bookTitle));
                readMenuInput();
            } else if (option.equals("Enquire")) {
                System.out.println("Ask our helpful librarian");
                readMenuInput();
            } else if (option.equals("exit")) {
                //flag = false;
                System.out.println("bye bye!");
                System.exit(0);
            } else {
                System.out.println("Select a valid option!!");
                readMenuInput();
            }
        }
    }

    public String reserveBook(String title) {
        Item book = librarian.findByTitle(title);//enquire the db

        if (book != null) {
            if (librarian.reserve(book)) {
                return ("Your item has been reserved");
            }
            return ("The item is on loan");
        }
        return ("We don't have that item yet");

    }

    public void displayAllItems() {
        if (librarian.displayAll().isEmpty()) {
            System.out.println("No items in the catalogue yet");
        }
        for (Item b : librarian.displayAll()) {
            System.out.println(b.displayDetails());
        }
    }

}
