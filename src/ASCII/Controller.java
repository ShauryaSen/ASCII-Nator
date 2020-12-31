package ASCII;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private Button asciiNateButton;
    @FXML private Label title, urlLabel;
    @FXML private TextField urlField;

    @FXML public void asciiNate(ActionEvent event) throws IOException{
        System.out.println("Image ASCII-Nated");

        Parent root = FXMLLoader.load(Main.class.getResource("/ASCII/Scene2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {

    }
}
