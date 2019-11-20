import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullName() throws NoSuchAlgorithmException, FileNotFoundException {
        Student tester = new Student("John", "Doe", "12345", "12345.png");

        assertEquals("John Doe", tester.getFullName());
    }

    @Test
    void getCardID() throws NoSuchAlgorithmException, FileNotFoundException {
        Student tester = new Student("John", "Doe", "12345", "12345.png");

        assertEquals(Arrays.toString(ViewController.hashedValue("12345", "salt")), tester.getCardID());
    }

    @Test
    void getPhotoPath() throws NoSuchAlgorithmException, FileNotFoundException {
        Student tester = new Student("John", "Doe", "12345", "12345.png");

        assertEquals("resources/images/12345.png", tester.getPhotoPath());
    }
}