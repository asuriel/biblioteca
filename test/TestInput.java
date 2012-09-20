import java.io.*;
import java.util.Scanner;

public class TestInput extends InputStream {

    private InputStream is;

    public TestInput(String myString) {
        is = new ByteArrayInputStream( myString.getBytes() );

    }

    @Override
    public int read() throws IOException {
        return is.read();
    }
}
