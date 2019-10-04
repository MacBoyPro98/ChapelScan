import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class ViewController {
    @FXML private Button scanInButton;
    @FXML private TextField scanInText;

    //List of users
    private ArrayList<Scan> scans = new ArrayList<>();
    //Create students list
    private HashMap <Integer, Student> students = new HashMap<>();

    private LocalDate date = LocalDate.now();;

    private void populateStudents(HashMap<Integer, Student> students) {
        //TODO: Update students list via scp

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("extra/testCSV.csv"));

            while (csvReader.ready()) {
                String[] data = csvReader.readLine().split(",");

                // Create new student object
                Student stu = new Student(data[0], data[1], data[2], data[3], data[4]);

                //Add student at cardID index
                students.put(Integer.parseInt(data[2]), stu);
            }
            csvReader.close();
        } catch (Exception ex) {
            System.out.println("\n[ERROR]: " + ex.toString() + "\n");
        }
    }



    private void writeToFile(String filePath, String id) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter csvWriter = new BufferedWriter(fileWriter);

            //Write to the file
            csvWriter.write(id.toString() + "\n");

            //Close the reader
            csvWriter.close();
        } catch (IOException ex) {
            System.out.println("\n[ERROR]: " + ex.toString() + "\n");
        }
    }

    public void scanInButtonPressed(ActionEvent event) {
        //get the text
        Integer id = Integer.parseInt(scanInText.getText());

        //check if student exists with card id
        if (students.containsKey(id)) {
            System.out.println("Found " + id);

            //add to scanning list
            writeToFile("extra/output-" + date.toString() + ".csv", id.toString());

            //Clear text for next entry
            scanInText.setText("");
        } else {
            //Warning
            System.out.println("Could not find " + id + " - Please scan again");

            writeToFile("extra/errors-" + date.toString() + ".csv", id.toString() + "\n");

            //Clear text for next entry
            scanInText.setText("");
        }
    }

    public void initialize() {
        //Open and read the students file
        populateStudents(students);
    }
}
