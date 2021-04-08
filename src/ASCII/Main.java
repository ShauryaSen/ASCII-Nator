package ASCII;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage1) throws Exception{
        Parent root = FXMLLoader.load(ASCII.Main.class.getResource("/ASCII/Scene1.fxml"));
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.setTitle("ASCII-Nator");
        stage1.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
