import javafx.beans.property.SimpleStringProperty;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Student extends ChapScan {
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty fullName;
    private SimpleStringProperty cardID;
    private SimpleStringProperty photoPath;

    private PropertyFile config = new PropertyFile();

    Student(String fName, String lName, String cardID, String photoPath) throws NoSuchAlgorithmException, FileNotFoundException {
        this.fName = new SimpleStringProperty(Arrays.toString(hash256(fName, "salt")));
        this.lName = new SimpleStringProperty(Arrays.toString(hash256(lName, "salt")));
        this.fullName = new SimpleStringProperty(fName + " " + lName);
        //TODO: Encrypt card ID
        this.cardID = new SimpleStringProperty(Arrays.toString(hash256(cardID, "salt")));
//        this.photoPath = new SimpleStringProperty(Arrays.toString(hash256(photoPath, "salt")));
        this.photoPath = new SimpleStringProperty(photoPath);
    }

    //METHODS
    private byte[] hash256(String value, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest((value + salt).getBytes(StandardCharsets.UTF_8));
    }

    String getFullName() {
        return fullName.get();
    }

    String getCardID() {
        return cardID.get();
    }

    String getPhotoPath() {
        return config.prop.getProperty("imageDir") + this.photoPath.get();
    }

    protected void printStudentInfo() {
        System.out.println(this.fName + " " + this.lName + ", " + this.cardID + ", " + this.photoPath);
    }
}
