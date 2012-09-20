import java.io.Console;
import java.util.Scanner;


public class Engine {


    public static void main(String[] args) {

     ConsoleControl control = new ConsoleControl(System.in);
        //control.init();
        control.readMenuInput();
    }
}
