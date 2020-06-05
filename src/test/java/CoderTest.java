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
            Coder.decode("C:\\Users\\serni\\Desktop\\Encode.txt",
                    "C:\\Users\\serni\\Desktop\\Encoded.txt", "abch");
        });
    }
    @Test
    public void fileContentChecker1() throws IOException{
        Coder.decode("C:\\Users\\serni\\Desktop\\Encode.txt",
                     "223","C:\\Users\\serni\\Desktop\\Encoded.txt");
        File file1 = new File("C:\\Users\\serni\\Desktop\\Encoded.txt");
        File file2 = new File("C:\\Users\\serni\\Desktop\\Template.txt");
        //Assertions.assertEquals(file1,file2);
        assertTrue(FileUtils.contentEquals(file1, file2));
    }
    @Test
    public void fileContentChecker2() throws IOException{
        Coder.decode("C:\\Users\\serni\\Desktop\\Encode1.txt",
                "3abf","C:\\Users\\serni\\Desktop\\Encoded1.txt");
        File file1 = new File("C:\\Users\\serni\\Desktop\\Encoded1.txt");
        File file2 = new File("C:\\Users\\serni\\Desktop\\Template1.txt");
        //Assertions.assertEquals(file1,file2);
        assertTrue(FileUtils.contentEquals(file1, file2));
    }

}
