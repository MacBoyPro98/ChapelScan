import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ViewController {
    @FXML private Button scanInButton;
    @FXML private TextField scanInText;
    @FXML private ImageView scanInImage;

    //Table
    @FXML private TableView<Scan> scanInTable;

    //List of users
    private ObservableList<Scan> scans = FXCollections.observableArrayList();
    //Create students list
    private ObservableMap<Integer, Student> students = FXCollections.observableHashMap();

    private final LocalDate date = LocalDate.now();

    private byte[] hashedValue(String val, String salt) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest((val + salt).getBytes(StandardCharsets.UTF_8));
    }

    private void populateStudents(ObservableMap<Integer, Student> students) {
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
            csvWriter.write(id + "\n");

            //Close the reader
            csvWriter.close();
        } catch (IOException ex) {
            System.out.println("\n[ERROR]: " + ex.toString() + "\n");
        }
    }

    public void scanInButtonPressed(ActionEvent event) {
        //get the text
        Integer id = Integer.parseInt(scanInText.getText());

        Scan currentScan = new Scan(students.get(id));

        // Duplicate checking
        if (scans.contains(currentScan)) {

            System.out.println(id.toString() + " already in list");

            //Clear text for next entry
            scanInText.setText("");
        } else {
            //check if student exists with card id
            if (students.containsKey(id)) {
                System.out.println("Found " + id.toString());

                //add to scanning list
                scans.add(0, new Scan(students.get(id)));
                writeToFile("extra/output-" + date.toString() + ".csv", id.toString());

                //Update TableView Items
                scanInTable.setItems(scans);

//                scanOutImage = new ImageView(currentScan.getPhoto());

                //Refresh Table
                scanInTable.refresh();

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
    }

    public void initialize() {
        //Open and read the students file
        populateStudents(students);

        //Setup table Columns
        TableColumn scanInFullName = new TableColumn<String, Scan>("Name");
        scanInFullName.setPrefWidth(175.0);
        TableColumn scanInPhoto = new TableColumn<ImageView, Scan>("Photo");
        scanInPhoto.setPrefWidth(425.0);
        scanInPhoto.setStyle("-fx-alignment: CENTER;");
        scanInTable.getColumns().addAll(scanInFullName, scanInPhoto);

        //Associate data with columns
        scanInFullName.setCellValueFactory(new PropertyValueFactory<String, Scan>("fullName"));
        scanInPhoto.setCellValueFactory(new PropertyValueFactory<ImageView, Scan>("photo"));

        scanInTable.setPlaceholder(new Label("No rows to display"));
    }
}
