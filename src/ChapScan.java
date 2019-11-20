import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
        System.out.println("I do this when I close");

        //TODO: Move files to the OLD Directory
//        try {
//            Files.move(new File("out/").toPath(), new File("OLD/").toPath(), StandardCopyOption.COPY_ATTRIBUTES);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
