import java.util.ArrayList;

public class Librarian {

    private Assistant assistant;


    public Librarian() {

        assistant = ServiceLocator.getFinder();
    }

    public void loadLibrary() {

        Movie first = new Movie("Citizen Kane", "1975", "Orson Welles", "10");
        Movie second = new Movie("Rear Window", "1950", "Hitchcock", "10");
        Movie third = new Movie("The Barbarian Invasions", "2003", "Denis Arcand", "9");
        Movie fourth = new Movie("DogVille", "2002", "Lars Von Trier", "5");
        Movie fifth = new Movie("Life is Beautiful", "1997", "Roberto Benigni", "8");
        Movie sixth = new Movie("Batman", "2012", "Nolan", "Very bad");
        assistant.AddItem("1", first);
        assistant.AddItem("2", second);
        assistant.AddItem("3", third);
        assistant.AddItem("4", fourth);
        assistant.AddItem("5", fifth);
        assistant.AddItem("6", sixth);
    }

    public void addItem(String code, Item a) {
        assistant.AddItem(code, a);
    }

    public ArrayList<Item> displayAll() {
        return assistant.findAll();
    }

    public boolean reserve(Item a) {
        if (a.isAvailable) {
            a.isAvailable = false;
            return true;
        }
        return false;
    }

    private void makeUnavailable(Item a) {
        a.isAvailable = false;
    }

    public Item findByTitle(String title) {
        return assistant.findByTitle(title);
    }

}
