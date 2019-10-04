public class Student implements Comparable<Student>{
    private String fName;
    private String lName;
    private String cardID;
    private String stuID;
    private String photoPath;

    Student(String fName, String lName, String cardID, String stuID, String photoPath) {
        this.fName = fName;
        this.lName = lName;
        //TODO: Encrypt card and student ID
        this.cardID = cardID;
        this.stuID = stuID;
        this.photoPath = photoPath;
    }

    @Override
    public int compareTo(Student comparestu) {
        String compareID = ((Student)comparestu).cardID;

        return this.cardID.compareTo(compareID);
    }

    protected void printStudentInfo() {
        System.out.println(this.fName + " " + this.lName + ", " + this.cardID + ", " + this.stuID +  ", " + this.photoPath);
    }
}
