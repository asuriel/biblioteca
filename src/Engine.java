public class Engine {


    public static void main(String[] args) {

        ServiceLocator.load(new ServiceLocator(new TextCatalogue()));
        Librarian librarian = new Librarian();
        //Scanner scanner = new Scanner();
        Console control = new Console();
        control.init(System.in, librarian);
        control.assignLibraryAccion();
        //control.readInput();

    }
}
