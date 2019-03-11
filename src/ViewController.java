import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ViewController {
    @FXML private Button scanInButton;
    @FXML private TextField scanInText;

    //List of users
    private LinkedList<LinkedList<String>> students = new LinkedList<>();
    private LinkedList<Scan> scans = new LinkedList<>();

    public void populateScans() {
        //read from file
        while ()

        //add to linked list
        scans.add();
    }

    public void scanInButtonPressed(ActionEvent event) {
        //get the text

        //add to scanning list
    }
}
