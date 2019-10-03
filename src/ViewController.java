import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ViewController {
    @FXML private Button scanInButton;
    @FXML private TextField scanInText;

    //List of users
    private ArrayList<Scan> scans = new ArrayList<>();
    //Create students list
    public ArrayList<Student> students = new ArrayList<>();

    private void populateStudents(ArrayList<Student> students) {
        //TODO: Update students list via scp

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("extra/testCSV.csv"));

            while (csvReader.ready()) {
                String[] data = csvReader.readLine().split(",");

                // Create new student object
                Student stu = new Student(data[0], data[1], data[2], data[3], data[4]);

                students.add(stu);
            }
            csvReader.close();

            // Sort the list of students by first name
            Collections.sort(students);
        } catch (Exception ex) {
            System.out.println("[Error]: " + ex.toString());
        }

        //TODO: DELETE - FOR DEBUG PURPOSES
        for (Student stu: students) {
            stu.printStudentInfo();
        }
    }

    public void scanInButtonPressed(ActionEvent event) {
        //get the text
        String id = scanInText.getText();

        //check if student exists with card id


        //add to scanning list
    }

    public void initialize() {
        //Open and read the students file
        populateStudents(students);
    }
}
