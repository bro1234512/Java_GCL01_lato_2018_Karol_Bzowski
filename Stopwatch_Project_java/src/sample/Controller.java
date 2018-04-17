package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Controller {
    public int minute = 0;
    public int secund = 0;
    public int milisec = 0;
    public int minuteStart;
    public int minuteStop;
    public int secundStart;
    public int secundStop;
    public int milisecStart;
    public int milisecStop;
    Stage primaryStage = new Stage();
    private boolean blinding = true;
    private boolean timerOn = false;

    @FXML
    private Canvas canvas;
    @FXML
    public TableView<Record> tabel;
    @FXML
    public TableColumn<Record, String> t1;
    @FXML
    public TableColumn<Record, String> t2;
    @FXML
    public TableColumn<Record, String> t3;
    @FXML
    public TableColumn<Record, String> t4;
    public ObservableList<Record> tabelData;

    @FXML
    void initialize() throws Exception {


        tabelData = FXCollections.observableArrayList();

        t1.setCellValueFactory(cellData -> cellData.getValue().getNameOfRecord());
        t2.setCellValueFactory(cellData -> cellData.getValue().getStartTime());
        t3.setCellValueFactory(cellData -> cellData.getValue().getStopTime());
        t4.setCellValueFactory(cellData -> cellData.getValue().getTime());
        tabel.setItems(tabelData);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        Timeline timelinedrawHour = new Timeline(new KeyFrame(Duration.millis(10), ae -> drawTime(gc)));
        timelinedrawHour.setCycleCount(Animation.INDEFINITE);
        timelinedrawHour.play();

        Timeline timelineanimation = new Timeline(new KeyFrame(Duration.seconds(0.5), ae -> animation()));
        timelineanimation.setCycleCount(Animation.INDEFINITE);
        timelineanimation.play();


    }


    private void drawTime(GraphicsContext gc) {
        String msg2;
        String msg;
        if (!timerOn && milisec == 0 && minute == 0 && secund == 0) {
            if (blinding) {
                msg = "00:00";
                msg2 = "00";
            } else {
                msg = "";
                msg2 = "";
            }
            Text text = new Text(msg);
            Text text2 = new Text(msg2);
            Font font = Font.loadFont("file:resources/fonts/font.TTF", 50);
            Font font2 = Font.loadFont("file:resources/fonts/font.TTF", 30);
            text.setFont(font);
            text2.setFont(font2);

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFont(font);
            gc.fillText(msg, canvas.getWidth() / 2 - text.getLayoutBounds().getWidth() / 2, canvas.getHeight() / 2 + text.getLayoutBounds().getHeight() / 2);
            gc.setFont(font2);
            gc.fillText(msg2, canvas.getWidth() / 2 + text.getLayoutBounds().getWidth() / 2, canvas.getHeight() / 2 + text.getLayoutBounds().getHeight() / 2 - text2.getLayoutBounds().getHeight() / 2);
        }
        if (timerOn) {


            milisec++;
            if (milisec == 100) {
                milisec = 0;
                secund++;
                if (secund == 60) {
                    secund = 0;
                    minute++;
                }
            }

            if (secund < 10) {
                if (minute < 10) {
                    msg = "0" + Integer.toString(minute) + ":0" + Integer.toString(secund);
                } else {
                    msg = Integer.toString(minute) + ":0" + Integer.toString(secund);
                }
            } else {
                if (minute < 10) {
                    msg = "0" + Integer.toString(minute) + ":" + Integer.toString(secund);
                } else {
                    msg = Integer.toString(minute) + ":" + Integer.toString(secund);
                }

            }
            msg2 = Integer.toString(milisec);

            Text text = new Text(msg);
            Text text2 = new Text(msg2);
            Font font = Font.loadFont("file:resources/fonts/font.TTF", 50);
            Font font2 = Font.loadFont("file:resources/fonts/font.TTF", 30);
            text.setFont(font);
            text2.setFont(font2);

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFont(font);
            gc.fillText(msg, canvas.getWidth() / 2 - text.getLayoutBounds().getWidth() / 2, canvas.getHeight() / 2 + text.getLayoutBounds().getHeight() / 2);
            gc.setFont(font2);
            gc.fillText(msg2, canvas.getWidth() / 2 + text.getLayoutBounds().getWidth() / 2, canvas.getHeight() / 2 + text.getLayoutBounds().getHeight() / 2 - text2.getLayoutBounds().getHeight() / 2);
        }
    }


    private void animation() {
        if (blinding)
            blinding = false;
        else
            blinding = true;

    }

    public void closeProgram(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void aboutMe(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutMe.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        primaryStage.setTitle("About author");
        primaryStage.setScene(new Scene(root, 602, 393));
        primaryStage.show();


    }

    public void startSW(ActionEvent actionEvent) {
        minuteStart = minute;
        secundStart = secund;
        milisecStart = milisec;
        timerOn = true;
    }

    public void stopSW(ActionEvent actionEvent) throws Exception {
        timerOn = false;
        minuteStop = minute;
        secundStop = secund;
        milisecStop = milisec;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTimePanel.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Controller2 control = fxmlLoader.getController();
        control.setitems(tabelData);
        control.setList(tabel);
        control.setSecund(secund);
        control.setMinute(minute);
        control.setMilisec(milisec);
        control.setSecundStop(secundStop);
        control.setSecundStart(secundStart);
        control.setMinuteStop(minuteStop);
        control.setMinuteStart(minuteStart);
        control.setMilisecStop(milisecStop);

        control.setMilisecStart(milisecStart);

        control.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Dodawanie pomiaru");
        primaryStage.setScene(new Scene(root, 295, 108));
        primaryStage.show();
    }

    public void clearSW(ActionEvent actionEvent) {
        milisec = 0;
        minute = 0;
        secund = 0;
        timerOn = false;
    }

    public void clearResults(ActionEvent actionEvent) {
        tabel.getItems().clear();

    }


    public void startSWButton(ActionEvent actionEvent) {
        minuteStart = minute;
        secundStart = secund;
        milisecStart = milisec;
        timerOn = true;


    }

    public void stopSWButton(ActionEvent actionEvent) throws Exception {
        timerOn = false;
        minuteStop = minute;
        secundStop = secund;
        milisecStop = milisec;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTimePanel.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Controller2 control = fxmlLoader.getController();
        control.setitems(tabelData);
        control.setList(tabel);
        control.setSecund(secund);
        control.setMinute(minute);
        control.setMilisec(milisec);
        control.setSecundStop(secundStop);
        control.setSecundStart(secundStart);
        control.setMinuteStop(minuteStop);
        control.setMinuteStart(minuteStart);
        control.setMilisecStop(milisecStop);
        control.setMilisecStart(milisecStart);
        Stage primaryStage = new Stage();
        control.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Dodawanie pomiaru");
        primaryStage.setScene(new Scene(root, 295, 108));
        primaryStage.show();


    }

    public void deleteRecord(ActionEvent actionEvent) {
        int index = tabel.getSelectionModel().getFocusedIndex();
        if(index >= 0){
            tabel.getItems().remove(index);
        }

    }



}












































