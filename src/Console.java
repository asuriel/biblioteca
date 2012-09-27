import java.io.*;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private Librarian librarian;
    private boolean loggedIn;
    private boolean systemWorking = true;
    private String currentUser;

    public Console() {
    }

    public void init(InputStream in, Librarian librarian) {

        scanner = new Scanner(in);
        this.librarian = librarian;
        librarian.loadLibrary();
        librarian.loadUsers();
        loggedIn = false;

        System.out.println("Welcome to the wonderful Biblioteca!\nWhat do you wish to do now?\n\n\n" +
                "Catalogue\n" +
                "Reserve Item\n" +
                "Enquire");
    }

    public String readInput() {

        //while (scanner.hasNext()) {
        String option = scanner.nextLine();

        if (option.equals("exit")) {
            systemWorking = false;
            return "Bye!";
        }
        return option;
        //}
    }

    public void assignLibraryAccion() {
        String option = readInput();

        while (systemWorking) {

            if (option.equals("Catalogue")) {
                System.out.println("Movies");
                if (readInput().equals("Movies")) {
                    displayAllItems();
                }
                assignLibraryAccion();

            } else if (option.equals("Reserve Item")) {
                if (loggedIn) {
                    System.out.println("Choose the book to reserve");
                    String bookTitle = readInput();
                    System.out.println(reserveBook(bookTitle));
                } else {
                    System.out.println("Please Login");
                }

                assignLibraryAccion();

            } else if (option.equals("Enquire")) {
                if (loggedIn) {
                    System.out.println(librarian.getUserDetails(currentUser));
                } else {
                    System.out.println("Ask our helpful librarian");
                }
                assignLibraryAccion();

            } else if (option.equals("Login")) {
                logUserIn();
                assignLibraryAccion();

            } else {
                System.out.println("Select a valid option!!");
                assignLibraryAccion();
            }
        }
    }

    public void logUserIn() {

        System.out.println("Please enter your userName");
        String uName = readInput();
        System.out.println("Please enter your passWord");
        String pwd = readInput();

        if (librarian.logUserIn(uName, pwd)) {
            loggedIn = true;
            currentUser = uName;
            System.out.println("Your login was successful");
        } else {
            System.out.println("Sorry, try again");
            logUserIn();
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
