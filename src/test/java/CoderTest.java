import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoderTest {
    //Coder test = new Coder();

    @Test
    public void testKeyChecker() throws IOException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Coder.decode("src/main/resources/input/Encode.txt",
                    "3abfk","src/main/resources/output/Encoded.txt");
        });
    }
    @Test
    public void fileContentChecker1() throws IOException{
        Coder.decode("src/main/resources/input/Encode.txt",
                     "3abf","src/main/resources/output/Encoded.txt");
        File file1 = new File("src/main/resources/output/Encoded.txt");
        File file2 = new File("src/main/resources/output/Template.txt");
        //Assertions.assertEquals(file1,file2);
        assertTrue(FileUtils.contentEquals(file1, file2));
    }
    @Test
    public void fileContentChecker2() throws IOException{
        Coder.decode("src/main/resources/input/Encode1.txt",
                "1453a","src/main/resources/output/Encoded1.txt");
        File file1 = new File("src/main/resources/output/Encoded1.txt");
        File file2 = new File("src/main/resources/output/Template1.txt");
        //Assertions.assertEquals(file1,file2);
        assertTrue(FileUtils.contentEquals(file1, file2));
    }

}
