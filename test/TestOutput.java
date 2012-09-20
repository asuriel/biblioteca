import java.io.OutputStream;
import java.io.PrintStream;

public class TestOutput extends PrintStream {

    public TestOutput(OutputStream outputStream) {
        super(outputStream);
    }
}
