package sample.view.scoreWeergave;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Created by Dynah Hemeleers on 14/03/2017.
 */
public class ScoreWeergaveView extends GridPane{
    private Label tijdLblText;
    private Label clicksLblText;
    private Label naamLblText;
    private TextField naamTxtField;
    private Button okBtn;
    private Label scoreTitellbl;
    //zou eventueel iets anders moeten worden
    private Label timeValueLbl;
    private Label clicksValueLbl;

    private Label testTimeLbl;

    public ScoreWeergaveView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.scoreTitellbl = new Label("Score");
        this.tijdLblText = new Label("Tijd:");
        this.clicksLblText = new Label("Aantal Clicks:");
        this.naamLblText = new Label("Naam:");
        this.naamTxtField = new TextField();
        this.okBtn = new Button("OK");

        this.testTimeLbl = new Label();

        //moeten eigenlijk leeg blijven maar doen we niet voor test!
        this.timeValueLbl = new Label();
        this.clicksValueLbl = new Label();
    }

    private void layoutNodes(){
        this.setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(10);

        GridPane.setConstraints(this.scoreTitellbl,0,0, 2, 1, HPos.CENTER, VPos.CENTER);
        this.add(scoreTitellbl, 0,0);

        this.add(tijdLblText,0,1);
        this.add(clicksLblText,0,2);
        this.add(naamLblText,0,3);
        this.add(naamTxtField,1,3);

        GridPane.setConstraints(this.okBtn,0,4,2,1,HPos.CENTER,VPos.CENTER);
        this.add(okBtn,0,4);

        //kan nog worden aangepast
        this.add(timeValueLbl, 1,1);
        this.add(clicksValueLbl,1,2);
    }


    Button getOkBtn(){
        return okBtn;
    }
    TextField getNaamTxtField(){
        return naamTxtField;
    }

    Label getTimeValueLbl(){
        return timeValueLbl;
    }

    Label getClicksValueLbl(){
        return clicksValueLbl;
    }

    Label getTestTimeLbl(){return testTimeLbl;}


}
