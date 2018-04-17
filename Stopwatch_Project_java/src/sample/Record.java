package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record{
    StringProperty nameOfRecord;
    StringProperty startTime;
    StringProperty stopTime;
    StringProperty time;

    public Record(String name,String start,String stop,String czas){
        this.nameOfRecord = new SimpleStringProperty(name);
        this.startTime = new SimpleStringProperty(start);
        this.stopTime = new SimpleStringProperty(stop);
        this.time = new SimpleStringProperty(czas);
    }


    public StringProperty getNameOfRecord() {
        return nameOfRecord;
    }

    public void setNameOfRecord(String nameOfRecord){
         this.nameOfRecord.set(nameOfRecord);
}

    public StringProperty getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public StringProperty getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime.set(stopTime);
    }

    public StringProperty getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }




}
