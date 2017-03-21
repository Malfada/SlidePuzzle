package sample.view.scoreWeergave;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ScoreDisplayView extends GridPane{
    private Label timeLblText;
    private Label clicksLblText;
    private Label nameLblText;
    private TextField nameTxtField;
    private Button okBtn;
    private Label scoreTitellbl;
    private Label timeValueLbl;
    private Label clicksValueLbl;

    public ScoreDisplayView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.scoreTitellbl = new Label("Score");
        this.timeLblText = new Label("Tijd:");
        this.clicksLblText = new Label("Aantal Clicks:");
        this.nameLblText = new Label("Naam:");
        this.nameTxtField = new TextField();
        this.okBtn = new Button("OK");
        this.timeValueLbl = new Label();
        this.clicksValueLbl = new Label();
    }

    private void layoutNodes(){
        this.setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(10);

        GridPane.setConstraints(this.scoreTitellbl,0,0, 2, 1, HPos.CENTER, VPos.CENTER);
        this.add(scoreTitellbl, 0,0);

        this.add(timeLblText,0,1);
        this.add(clicksLblText,0,2);
        this.add(nameLblText,0,3);
        this.add(nameTxtField,1,3);

        GridPane.setConstraints(this.okBtn,0,4,2,1,HPos.CENTER,VPos.CENTER);
        this.add(okBtn,0,4);
        this.add(timeValueLbl, 1,1);
        this.add(clicksValueLbl,1,2);
    }

    Button getOkBtn(){
        return okBtn;
    }
    TextField getNameTxtField(){
        return nameTxtField;
    }
    Label getTimeValueLbl(){
        return timeValueLbl;
    }
    Label getClicksValueLbl(){
        return clicksValueLbl;
    }

}
