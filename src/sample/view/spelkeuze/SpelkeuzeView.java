package sample.view.spelkeuze;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Dynah Hemeleers on 12/03/2017.
 */
public class SpelkeuzeView extends VBox{
    private Button spel1btn, spel2btn, spel3btn;
    private Label spelkeuzelbl;

    public SpelkeuzeView(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.spelkeuzelbl= new Label("Spel Keuze");
        this.spel1btn = new Button("Spel 1");
        this.spel2btn = new Button("Spel 2");
        this.spel3btn = new Button("Spel 3");
    }

    private void layoutNodes() {
        this.buttonLayout(spel1btn);
        this.buttonLayout(spel2btn);
        this.buttonLayout(spel3btn);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.setPrefHeight(230);
        this.getChildren().addAll(spelkeuzelbl, spel1btn, spel2btn, spel3btn);
    }

    private void buttonLayout(Button button) {
        button.setPrefWidth(100);
        button.setPrefHeight(30);
    }

    Button getSpel1(){
        return spel1btn;
    }
    Button getSpel2(){
        return spel2btn;
    }
    Button getSpel3(){
        return spel3btn;
    }
    Label getSpelkeuze(){
        return spelkeuzelbl;
    }
}