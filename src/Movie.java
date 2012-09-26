public class Movie extends Item {

    private String director;
    private String rating;
    private String year;

    public Movie(String title, String year, String director, String rating) {
        super(title);

        this.director = director;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + "  " + year + "  " + director + "  " + rating + "  " + super.displayAvailability();
    }
}
