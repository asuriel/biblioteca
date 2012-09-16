import java.util.ArrayList;
import java.util.HashMap;

public class Cataloguer {

    private HashMap<String, Book> books = new HashMap<String, Book>();

    public void addBook(String code, Book a)
    {
        books.put(code, a);
    }

    public ArrayList<Book> displayAll()
    {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        allBooks.addAll(books.values());
        return allBooks;
    }
    public boolean reserve(Book a)
    {
        if(a.isAvailable)
        {
            a.isAvailable = false;
            return true;
        }
        return false;
    }

    private void makeUnavailable(Book a)
    {
        a.isAvailable = false;
    }
}
