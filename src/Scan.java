import javafx.beans.property.SimpleStringProperty;

public class Scan {
    private SimpleStringProperty fullName;
    private SimpleStringProperty cardID;
    private SimpleStringProperty photoPath;

    Scan(Student stu) {
        this.fullName = new SimpleStringProperty(stu.getFullName());
        this.cardID = new SimpleStringProperty(stu.getCardID());
        this.photoPath = new SimpleStringProperty(stu.getPhotoPath());
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

    public String getPhotoPath() {
        return photoPath.getName();
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath.set(photoPath);
    }
}
