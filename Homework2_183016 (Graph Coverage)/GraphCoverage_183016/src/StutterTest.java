import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StutterTest {


    @Test
    public void shouldTestIOException(){
        //the example.txt file does not exist
        assertThrows(IOException.class, () -> Stutter.stut(new BufferedReader(new InputStreamReader(new FileInputStream("example.txt")))));
    }

    public static Collection<Object[]> testFiles() {
        return Arrays.asList(new Object[][]{
                {"test1.txt", "empty txt file"},
                {"test2.txt", "enters while - inLine is not null"},
                {"test3.txt", "enters while – inLine is not null enters for"},
                {"test4.txt", "enters while – inLine is not null enters for"},
                {"test5.txt", "enters while – inLine is not null enters while – inLine is not null"},
                {"test6.txt", "enters while – inLine is not null enters while – inLine is not null enters for"},
                {"test7.txt", "enters while – inLine is not null enters for enters for"},
                {"test8.txt", "enters while – inLine is not null enters for enters for"}
        });
    }

}
