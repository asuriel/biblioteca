public class Engine {


    public static void main(String[] args) {

        ServiceLocator.load(new ServiceLocator(new TextCatalogue()));
        Librarian librarian = new Librarian();

        Console control = new Console();
        control.init(System.in, librarian);
        control.readMenuInput();

    }
}
