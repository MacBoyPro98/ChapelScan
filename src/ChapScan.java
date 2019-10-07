import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.bind.annotation.XmlElementDecl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class ChapScan extends Application {
    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//
//        TabPane tabPane = new TabPane();
//
//        //Scan In Tab
//        Tab tab1 = new Tab("Scan-In");
//        //Create Tab 1 Content
//        TableView scanInTableView = new TableView();
//
//        TableColumn<String, Student> nameCol = new TableColumn<>("Name");
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
//
//        TableColumn<String, Student> photoCol = new TableColumn<>("Photo");
//        photoCol.setCellValueFactory(new PropertyValueFactory<>("photoPath"));
//
//        //Add Columns
//        scanInTableView.getColumns().add(nameCol);
//        scanInTableView.getColumns().add(photoCol);
//
//        //Add Data
//        for (Student stu:) {
//
//        }
//
//        //Add content to the tab
//        tab1.setContent(scanInTableView);
//
//        //Scan Out Tab
//        Tab tab2 = new Tab("Scan-Out"  , new Label("Show all cars available"));
//
//        tabPane.getTabs().add(tab1);
//        tabPane.getTabs().add(tab2);
//
//        VBox vBox = new VBox(tabPane);
//        vBox.autosize();
//
//        Scene scene = new Scene(vBox);
//
//        primaryStage.setTitle("ChapelScan");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ChapScanView.fxml"));
        primaryStage.setTitle("ChapelScan");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
