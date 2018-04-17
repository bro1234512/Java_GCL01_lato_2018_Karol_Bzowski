package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller3 {
    @FXML
    private ImageView image;

    @FXML
    void initialize() throws FileNotFoundException {
        Image imageView = new Image(new FileInputStream("C:\\Users\\Karol\\IdeaProjects\\company-app-master\\Stopwatch_Project_java\\src\\sample\\pirat.png"));
        image.setImage(imageView);

    }

}
