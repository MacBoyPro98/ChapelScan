import javafx.beans.property.SimpleStringProperty;

public class Student{
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty fullName;
    private SimpleStringProperty cardID;
    private SimpleStringProperty stuID;
    private SimpleStringProperty photoPath;

    Student(String fName, String lName, String cardID, String stuID, String photoPath) {
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.fullName = new SimpleStringProperty(fName + " " + lName);
        //TODO: Encrypt card and student ID
        this.cardID = new SimpleStringProperty(cardID);
        this.stuID = new SimpleStringProperty(stuID);
        this.photoPath = new SimpleStringProperty(photoPath);
    }

    //METHODS

    protected String getFullName() {
        return fullName.get();
    }

    public String getCardID() {
        return cardID.get();
    }

    protected String getPhotoPath() {
        return "extra/photos/" + this.photoPath;
    }

    protected void printStudentInfo() {
        System.out.println(this.fName + " " + this.lName + ", " + this.cardID + ", " + this.stuID +  ", " + this.photoPath);
    }
}
