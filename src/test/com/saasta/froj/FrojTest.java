package test.com.saasta.froj;

import com.jsaasta.froj.*;
import org.junit.Test;

import java.io.IOException;

public class FrojTest {

    @Test
    public void testHelloWorld() throws IOException {
        Froj froj = new Froj();
        froj.runFile("src/test/com/saasta/froj/froj_test.froj");
    }
}