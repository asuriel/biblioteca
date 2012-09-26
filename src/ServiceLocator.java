public class ServiceLocator {

    //Im not sure how this is a singleton
    private static ServiceLocator singleLocator;
    private Assistant assistant;

    public ServiceLocator(Assistant assistant) {
        this.assistant = assistant;
    }

    public static Assistant getFinder() {

        return singleLocator.assistant;
    }

    //this will be called from the tester or engine
    public static void load(ServiceLocator locator) {
        singleLocator = locator;
    }
}
