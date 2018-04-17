package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller2 {
    public Stage primaryStage;
    public int minuteStart;
    public int minuteStop;
    public int secundStart;
    public int secundStop;
    public int milisecStart;
    public int milisecStop;
    public int minute;
    public int secund;
    public int milisec;

    public int bsecund ;
    public int bmilisec ;

    public Label labelError;
    public ObservableList<Record> tabelData;
    public TableView<Record> tabel;
    @FXML
    public TextField addField;

    public void addRecord(ActionEvent actionEvent) {
        Pattern pattern = Pattern.compile("[0-1A-Za-z]");
        Matcher matcher = pattern.matcher(addField.getText());


        if((matcher.find())){
            labelError.setVisible(false);

            if(milisecStop < milisecStart){
                secundStop--;
                bmilisec = (milisecStop+100);
            }
            else{
                bmilisec = milisecStop;
            }
            if(secundStop < secundStart){
                minuteStop--;
                bsecund = (secundStop+60);
            }
            else{
                bsecund = secundStop;
            }

            tabelData.add(new Record(addField.getText(),
                    Integer.toString(minuteStart)+":"+Integer.toString(secundStart)+":"+Integer.toString(milisecStart),
                    Integer.toString(minuteStop)+":"+Integer.toString(secundStop)+":"+Integer.toString(milisecStop),
                    Integer.toString(minuteStop - minuteStart)+":"+Integer.toString(bsecund - secundStart)+":"+Integer.toString(bmilisec - milisecStart)));
            tabel.setItems(tabelData);
            primaryStage.close();
        }
        else {
            labelError.setVisible(true);
        }


    }



    public void addCancel() {
       primaryStage.close();

    }


    public void setitems(ObservableList<Record> tabelData) {
        this.tabelData = tabelData;
    }

    public void setList(TableView<Record> tabel) {
    this.tabel = tabel;
    }

    public void setSecund(int secund) {
        this.secund = secund;
    }

    public void setMinuteStop(int minuteStop) {
        this.minuteStop = minuteStop;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setMilisec(int milisec) {
        this.milisec = milisec;
    }

    public void setSecundStart(int secundStart) {
        this.secundStart = secundStart;
    }

    public void setSecundStop(int secundStop) {
        this.secundStop = secundStop;
    }

    public void setMinuteStart(int minuteStart) {
        this.minuteStart = minuteStart;
    }

    public void setMilisecStop(int milisecStop) {
        this.milisecStop = milisecStop;
    }

    public void setMilisecStart(int milisecStart) {
        this.milisecStart = milisecStart;
    }


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
