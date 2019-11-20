import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScanTest {

    @Test
    void getFullName() throws NoSuchAlgorithmException, FileNotFoundException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "12345.png"));

        assertEquals("John Doe", tester.getFullName());
    }

    @Test
    void setFullName() throws NoSuchAlgorithmException, FileNotFoundException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "12345.png"));

        tester.setFullName("Josh Doe");

        assertEquals("Josh Doe", tester.getFullName());
    }

    @Test
    void getCardID() throws NoSuchAlgorithmException, FileNotFoundException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "12345.png"));

        assertEquals(Arrays.toString(ViewController.hashedValue("12345", "salt")), tester.getCardID());
    }

    @Test
    void setCardID() throws NoSuchAlgorithmException, FileNotFoundException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "12345.png"));

        tester.setCardID("12346");

        assertEquals("12346", tester.getCardID());
    }
}