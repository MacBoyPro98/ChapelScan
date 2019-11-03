import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class ViewController extends ChapScan {
    @FXML private Button scanInButton;
    @FXML private Button scanOutButton;
    @FXML private TextField scanInText;
    @FXML private TextField scanOutText;

    //Tables
    @FXML private TableView<Scan> scanInTable;
    @FXML private TableView<Scan> scanOutTable;

    private PropertyFile config = new PropertyFile();

    //List of users
    private ObservableList<Scan> scansIn = FXCollections.observableArrayList();
    private ObservableList<Scan> scansOut = FXCollections.observableArrayList();
    //Create students list
    private ObservableMap<Integer, Student> students = FXCollections.observableHashMap();

    // Variables for file creation
    private String date = LocalDate.now().toString();
    private String localMachineName = java.net.InetAddress.getLocalHost().getHostName();

    public ViewController() throws UnknownHostException, FileNotFoundException {
    }

    private byte[] hashedValue(String val, String salt) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest((val + salt).getBytes(StandardCharsets.UTF_8));
    }

    private void populateStudents(ObservableMap<Integer, Student> students) {
        //TODO: Update students list via scp/sftp

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(config.prop.getProperty("csvLocation")));

            while (csvReader.ready()) {
                String[] data = csvReader.readLine().split(",");

                // Create new student object
                Student stu = new Student(data[0], data[1], data[2], data[3], data[2] + ".png");

                //Add student at cardID index
                students.put(Integer.parseInt(data[2]), stu);
            }
            csvReader.close();
        } catch (Exception ex) {
            System.out.println("\n[ERROR]: " + ex.toString() + "\n");
        }
    }

    private void writeToFile(String filePath, String id) throws IOException {
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

    public void scanButtonPressed(ActionEvent event) throws IOException {
        String file = "";
        String text = "";
        
        if (event.getSource() == scanInButton || event.getSource() == scanInText) {
            file = config.prop.getProperty("outfileDir") + "CHAPIN_" + date + "_" + localMachineName + ".txt";
            text = scanInText.getText();

            //get the text
            Integer id = Integer.parseInt(text);

            //check if student exists with card id
            if (students.containsKey(id)) {
                Scan newScan = new Scan(students.get(id));

                //check duplicates
                if (!scansIn.contains(newScan)) {
                    //add to scanning list
                    scansIn.add(0, newScan);
                    writeToFile(file, id.toString());

                    //Update TableView Items
                    scanInTable.setItems(scansIn);

                    //Refresh Table
                    scanInTable.refresh();

                    //Clear text for next entry
                    scanInText.setText("");
                } else {
                    System.out.println("Duplicate Scan Detected");

                    //Refresh Table
                    scanInTable.refresh();

                    //Clear text for next entry
                    scanInText.setText("");
                }
//            System.out.println("Found " + id.toString());
            } else {
                //Warning
                System.out.println("Could not find " + id + " - Please scan again");

                writeToFile(config.prop.getProperty("outfileDir") + "CHAPERRORS_" + date + "_" + localMachineName + ".txt", id.toString() + "\n");

                //Clear text for next entry
                scanInText.setText("");
            }
        } else if (event.getSource() == scanOutButton || event.getSource() == scanOutText) {
            file = config.prop.getProperty("outfileDir") + "CHAPOUT_" + date + "_" + localMachineName + ".txt";
            text = scanOutText.getText();

            //get the text
            Integer id = Integer.parseInt(text);

            //check if student exists with card id
            if (students.containsKey(id)) {
                Scan newScan = new Scan(students.get(id));

                //check duplicates
                if (!scansOut.contains(newScan)) {
                    //add to scanning list
                    scansOut.add(0, newScan);
                    writeToFile(file, id.toString());

                    //Update TableView Items
                    scanOutTable.setItems(scansOut);

                    //Refresh Table
                    scanOutTable.refresh();

                    //Clear text for next entry
                    scanOutText.setText("");
                } else {
                    System.out.println("Duplicate Scan Detected");

                    //Refresh Table
                    scanOutTable.refresh();

                    //Clear text for next entry
                    scanOutText.setText("");
                }
//            System.out.println("Found " + id.toString());
            } else {
                //Warning
                System.out.println("Could not find " + id + " - Please scan again");

                writeToFile(config.prop.getProperty("outfileDir") + "CHAPERRORS_" + date + "_" + localMachineName + ".txt", id.toString() + "\n");

                //Clear text for next entry
                scanOutText.setText("");
            }
        } else {
            System.out.println(event.getSource() + " triggered event");
            System.exit(1);
        }
    }

    public void initialize() throws FileNotFoundException {
        localMachineName = localMachineName.split("-")[0];

        // format the date
        String[] formattedDateVars = date.split("-");
        formattedDateVars[0] = formattedDateVars[0].substring(2);
        date = formattedDateVars[0] + formattedDateVars[1] + formattedDateVars[2];

        String[] paths = {
                config.prop.getProperty("outfileDir") + "CHAPIN_" + date + "_" + localMachineName + ".txt",
                config.prop.getProperty("outfileDir") + "CHAPOUT_" + date + "_" + localMachineName + ".txt",
                config.prop.getProperty("outfileDir") + "CHAPTARDY_" + date + "_" + localMachineName + ".txt",
                config.prop.getProperty("outfileDir") + "CHAPERRORS_" + date + "_" + localMachineName + ".txt"
        };

        for (String path:paths) {
            try {
                Files.deleteIfExists(Paths.get(path));
                System.out.println(path + " deleted");
            } catch (IOException ex) {
                System.out.println("path doesnt exist");
            }
        }

        //Open and read the students file
        populateStudents(students);

        //Setup Scan-In table
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

        //Setup Scan-Out table
        TableColumn scanOutFullName = new TableColumn<String, Scan>("Name");
        scanOutFullName.setPrefWidth(175.0);
        TableColumn scanOutPhoto = new TableColumn<ImageView, Scan>("Photo");
        scanOutPhoto.setPrefWidth(425.0);
        scanOutPhoto.setStyle("-fx-alignment: CENTER;");
        scanOutTable.getColumns().addAll(scanOutFullName, scanOutPhoto);

        //Associate data with columns
        scanOutFullName.setCellValueFactory(new PropertyValueFactory<String, Scan>("fullName"));
        scanOutPhoto.setCellValueFactory(new PropertyValueFactory<ImageView, Scan>("photo"));

        scanOutTable.setPlaceholder(new Label("No rows to display"));
    }
}
