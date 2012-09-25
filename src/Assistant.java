import java.util.ArrayList;

public interface Assistant {

    public void AddItem(String code, Item a);

    public ArrayList<Item> findAll();

    public Item findByTitle(String title);

    public Item findByCode(String code);
}
