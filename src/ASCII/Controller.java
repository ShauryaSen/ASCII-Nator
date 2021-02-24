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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private Button asciiNateButton;
    @FXML private Label title, urlLabel;
    @FXML private TextField urlField;
    BufferedImage image;

    @FXML public void asciiNate(ActionEvent event) throws IOException, URISyntaxException {
        System.out.println("Image ASCII-Nated");

        //Save user input URL
        URL url = new URL(urlField.getText());

        // create the file to output to
        Writer writer = new FileWriter("asciiArt.txt");

        // Read the image
        try {
            image = ImageIO.read(url);

        } catch (IOException fx) {
            System.out.println("IOException (lul bad)");

        }
        catch (NullPointerException npx) {
            System.out.println("NullPointerException thrown");
        }

        // loop through every single pixel
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                // Store the RGB of the current pixel in
                Color pixelRGB = new Color(image.getRGB(y,x));

                // get the current pixel's grayscale
                double grayscale = (0.299 * pixelRGB.getRed()) + (0.587 * pixelRGB.getGreen()) + (0.114 * pixelRGB.getBlue());

                // based on the grayscale, write down an ascii to replace it with
                writer.write(asciiNate(grayscale));

                writer.flush();
            }
            writer.write("\n"); // writes a new line after each row
        }
        writer.close();

        //Open ascii-Nated image
        try
        {
            //constructor of file class having file as argument
            File file = new File("asciiArt.txt");
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();

            //check file exists or not
            if(file.exists()) {
                desktop.open(file);   //open the specified file
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //Load new page
//        Parent root = FXMLLoader.load(Main.class.getResource("/ASCII/Scene2.fxml"));
//        Stage stage2 = new Stage();
//        Scene scene = new Scene(root);
//        stage2.setScene(scene);
//        stage2.setMaximized(true);
//        stage2.show();
    }

    private char asciiNate(double g) {

        String map = "#@$/=:. ";

        return map.charAt((int)(map.length() * g / 256.0));

    }
    /*
        if (g > 230) {
            return ' ';
        } else if (g > 205) {
            return '.';
        } else if (g > 180) {
            return ':';
        } else if (g > 145) {
            return '=';
        } else if (g > 110) {
            return '/';
        } else if (g > 75) {
            return '$';
        } else if (g > 40) {
            return '@';
        } else {
            return '#';
        }
    }
    */


    @Override
    public void initialize(URL url, ResourceBundle resources) {

    }
}
