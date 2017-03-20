package sample.view.highScores;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HighScoreView extends GridPane {
    private ArrayList<Label> placementLblList , nameLblList, clickLblList, timeLblList, dateLblList;
    private int length;
    private static final int TOP_10 = 10;
    private Button returnBtn;

    public HighScoreView(int nrOfEnties){
        setLength(nrOfEnties);
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        returnBtn = new Button("Menu");
        setLblLists();
    }

    private void layoutNodes(){
        this.setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(10);
        for(int i = 0; i < length; i++){
            this.add(placementLblList.get(i),0, i);
            this.add(nameLblList.get(i), 1, i);
            this.add(clickLblList.get(i), 2, i);
            this.add(timeLblList.get(i), 3, i);
            this.add(dateLblList.get(i), 4, i);
        }
        this.add(returnBtn, 0, length);
        GridPane.setConstraints(returnBtn, 0, length, 5, 1, HPos.CENTER, VPos.CENTER);
    }

    private void setLength(int nrOfEnties) {
        if(nrOfEnties < TOP_10) {
            this.length = nrOfEnties;
        } else {
            this.length = TOP_10;
        }
    }

    private void setLblLists() {
        this.placementLblList = new ArrayList<>();
        this.nameLblList = new ArrayList<>();
        this.clickLblList = new ArrayList<>();
        this.timeLblList = new ArrayList<>();
        this.dateLblList = new ArrayList<>();
        for(int i = 0; i < length; i++){
            Label placement = new Label(i+1 + ".");
            placementLblList.add(placement);
            Label name = new Label();
            nameLblList.add(name);
            Label clicks = new Label();
            clickLblList.add(clicks);
            Label time = new Label();
            timeLblList.add(time);
            Label date = new Label();
            dateLblList.add(date);
        }
    }

    ArrayList<Label> getNameLblList(){
        return nameLblList;
    }
    ArrayList<Label> getClickLblList(){
        return clickLblList;
    }
    ArrayList<Label> getTimeLblList(){
        return timeLblList;
    }
    ArrayList<Label> getDateLblList(){
        return dateLblList;
    }
    Button getReturnBtn() {
        return returnBtn;
    }
}
