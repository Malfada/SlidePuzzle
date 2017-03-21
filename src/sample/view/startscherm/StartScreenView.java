package sample.view.startscherm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StartScreenView extends VBox {
    private Button playBtn, hScoreBtn, exitBtn;

    public StartScreenView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    private void initializeNodes() {
        this.playBtn = new Button("Play");
        playBtn.defaultButtonProperty().bind(playBtn.focusedProperty());
        this.hScoreBtn = new Button("High Scores");
        hScoreBtn.defaultButtonProperty().bind(hScoreBtn.focusedProperty());
        this.exitBtn = new Button("Exit");
        exitBtn.defaultButtonProperty().bind(exitBtn.focusedProperty());
    }

    private void layoutNodes() {
        this.buttonLayout(playBtn);
        this.buttonLayout(hScoreBtn);
        this.buttonLayout(exitBtn);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.setPrefHeight(230);
        this.getChildren().addAll(playBtn, hScoreBtn, exitBtn);
    }

    private void buttonLayout(Button button) {
        button.setPrefWidth(100);
        button.setPrefHeight(30);
    }

    Button getPlayBtn() {
        return playBtn;
    }

    Button gethScoreBtn() {
        return hScoreBtn;
    }

    Button getExitBtn() {
        return exitBtn;
    }

}
