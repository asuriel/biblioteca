public class Item {

    protected boolean isAvailable;
    private String title;

    public Item(String title) {

        this.title = title;
        isAvailable = true;
    }

    public Item() {
        isAvailable = true;
    }

    public String displayDetails() {
        return title;
    }

    public String displayTitle() {
        return title;
    }

    public String displayAvailability() {

        return (isAvailable) ? "Available" : "Unavailable";
    }
}
