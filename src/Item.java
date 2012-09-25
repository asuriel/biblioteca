public class Item {

    protected boolean isAvailable;
    private String title;

    public Item(String title){//}, boolean availability) {

        this.title = title;
        isAvailable = true;
    }

    public Item(){
        isAvailable = true;
    }

    public String displayTitle() {
        return title;
    }
}
