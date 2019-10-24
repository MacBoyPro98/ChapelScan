import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Scan extends ChapScan {
    private SimpleStringProperty fullName;
    private SimpleStringProperty cardID;
    private ImageView photo;

    Scan(Student stu) {
        this.fullName = new SimpleStringProperty(stu.getFullName());
        this.cardID = new SimpleStringProperty(stu.getCardID());
        try {
            this.photo = new ImageView(new Image(new FileInputStream(stu.getPhotoPath())));
        } catch (FileNotFoundException ex) {
            File file = new File("resources/photos/No_picture_available_25.png");
            this.photo = new ImageView(new Image(file.toURI().toString()));
        }
        this.photo.maxHeight(125);
        this.photo.setFitHeight(125);
        this.photo.setPreserveRatio(true);
        this.photo.setSmooth(true);
        this.photo.setCache(true);
    }

    //METHODS

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getCardID() {
        return cardID.get();
    }

    public void setCardID(String cardID) {
        this.cardID.set(cardID);
    }

    public ImageView getPhoto() {
        return photo;
    }
}
