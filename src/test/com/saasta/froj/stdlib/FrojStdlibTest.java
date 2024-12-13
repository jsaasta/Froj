package test.com.saasta.froj.stdlib;

import com.jsaasta.froj.Froj;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FrojStdlibTest {

    @Test
    public void test_Stdlib_Clock() throws IOException {
        Froj froj = new Froj();
        froj.runFile("src/test/com/saasta/froj/stdlib/froj_stdlib_clock.froj");
        froj.runFile("src/test/com/saasta/froj/stdlib/froj_stdlib_fileReader.froj");
        try {
            froj.runFile("src/test/com/saasta/froj/stdlib/froj_stdlib_socketserver.froj");
        } catch(NullPointerException ex){

        }
    }

}
