import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Files;

public class ChapScan extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ChapScanView.fxml"));

        primaryStage.setTitle("ChapelScan");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
