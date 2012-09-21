import java.util.ArrayList;

public class Librarian {

    private Assistant assistant;


    public Librarian(Assistant assistant) {

        assistant = ServiceLocator.getFinder();
    }

    public void addItem(String code, Item a)
    {
        assistant.AddItem(code, a);
    }

    public ArrayList<Item> displayAll()
    {
        return assistant.findAll();
    }

    public boolean reserve(Item a)
    {
        if(a.isAvailable)
        {
            a.isAvailable = false;
            return true;
        }
        return false;
    }

    private void makeUnavailable(Item a)
    {
        a.isAvailable = false;
    }

    public Item findByTitle(String title) {
        return assistant.findByTitle(title);
    }
}
