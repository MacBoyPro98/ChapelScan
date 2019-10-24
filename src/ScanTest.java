import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ScanTest {

    @Test
    void getFullName() throws NoSuchAlgorithmException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "123456", "12345.png"));

        assertEquals("John Doe", tester.getFullName());
    }

    @Test
    void setFullName() throws NoSuchAlgorithmException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "123456", "12345.png"));

        tester.setFullName("Josh Doe");

        assertEquals("Josh Doe", tester.getFullName());
    }

    @Test
    void getCardID() throws NoSuchAlgorithmException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "123456", "12345.png"));

        assertEquals("12345", tester.getCardID());
    }

    @Test
    void setCardID() throws NoSuchAlgorithmException {
        //Create tester object
        Scan tester = new Scan(new Student("John", "Doe", "12345", "123456", "12345.png"));

        tester.setCardID("12346");

        assertEquals("12346", tester.getCardID());
    }
}