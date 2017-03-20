package sample.view.spelkeuze;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GameChoiceView extends VBox{
    private Button game1Btn, game2Btn, game3Btn;
    private Label titleLbl;

    public GameChoiceView(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.titleLbl = new Label("Pick game");
        this.game1Btn = new Button("Game 1");
        this.game2Btn = new Button("Game 2");
        this.game3Btn = new Button("Game 3");
    }

    private void layoutNodes() {
        this.buttonLayout(game1Btn);
        this.buttonLayout(game2Btn);
        this.buttonLayout(game3Btn);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.setPrefHeight(230);
        this.getChildren().addAll(titleLbl, game1Btn, game2Btn, game3Btn);
    }

    private void buttonLayout(Button button) {
        button.setPrefWidth(100);
        button.setPrefHeight(30);
    }

    Button getSpel1(){
        return game1Btn;
    }
    Button getSpel2(){
        return game2Btn;
    }
    Button getSpel3(){
        return game3Btn;
    }
    
}