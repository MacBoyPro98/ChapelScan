public class Scan {
    private String fName;
    private String lName;
    private Integer cardID;
    private Integer studentID;

    Scan(String fName, String lName, Integer cardID, Integer studentID) {
        this.fName = fName;
        this.lName = lName;
        this.cardID = cardID;
        this.studentID = studentID;
    }

    /* Getters */
    public String getfName() {
        return this.fName;
    }

    public String getlName() {
        return this.lName;
    }

    public Integer getStudentID() {
        return this.studentID;
    }

    public Integer getCardID() {
        return this.cardID;
    }

    /* Setters */
    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setCardID(Integer cardID) {
        this.cardID = cardID;
    }

    /* METHODS */
    public String getFullName() {
        return this.fName + " " + this.lName;
    }
}
