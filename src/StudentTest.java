import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullName() throws NoSuchAlgorithmException {
        Student tester = new Student("John", "Doe", "12345", "123456", "12345.png");

        assertEquals("John Doe", tester.getFullName());
    }

    @Test
    void getCardID() throws NoSuchAlgorithmException {
        Student tester = new Student("John", "Doe", "12345", "123456", "12345.png");

        assertEquals("12345", tester.getCardID());
    }

    @Test
    void getPhotoPath() throws NoSuchAlgorithmException {
        Student tester = new Student("John", "Doe", "12345", "123456", "12345.png");

        assertEquals("resources/photos/12345.png", tester.getPhotoPath());
    }
}