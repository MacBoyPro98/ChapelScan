import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChapScan extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/ChapScanView.fxml"));

        //TODO: Add SFTP downloading of the encrypted .csv file

        //TODO: Decrypt the file


        primaryStage.setTitle("ChapelScan");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() {
        //TODO: Add SFTP uploading of the finished user files
        System.out.println("I do this when I close");

        //TODO: Move files to the OLD Directory
    }

    public static void main(String[] args) {
        launch(args);
    }
}
