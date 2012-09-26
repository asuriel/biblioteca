import java.util.ArrayList;
import java.util.HashMap;

public class TextCatalogue implements Assistant {

    private HashMap<String, Item> catalogue;

    public TextCatalogue() {

        catalogue = new HashMap<String, Item>();
    }

    @Override
    public void AddItem(String code, Item a) {

        catalogue.put(code, a);
    }

    @Override
    public ArrayList<Item> findAll() {
        ArrayList<Item> items = new ArrayList<Item>();

        for (Item item : catalogue.values()) {
            items.add(item);
        }
        return items;
    }

    @Override
    public Item findByTitle(String title) {

        for (Item item : catalogue.values()) {
            if (item.displayTitle().equals(title)) {
                return item;
            }
        }
        return null;
     }

    @Override
    public Item findByCode(String code) {

        for (String key : catalogue.keySet()) {
            if (key == code) {
                return catalogue.get(key);//??
            }
        }
        return null;
    }


}
