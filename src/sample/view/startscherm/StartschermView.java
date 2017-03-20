package sample.view.startscherm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StartschermView extends VBox {
    private Button playbtn, hScorebtn, exitbtn;

    public StartschermView() {
        this.initializeNodes();
        this.layoutNodes();
    }

    private void initializeNodes() {
        this.playbtn = new Button("Play");
        this.hScorebtn = new Button("High Scores");
        this.exitbtn = new Button("Exit");
    }

    private void layoutNodes() {
        this.buttonLayout(playbtn);
        this.buttonLayout(hScorebtn);
        this.buttonLayout(exitbtn);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.setPrefHeight(230);
        this.getChildren().addAll(playbtn, hScorebtn, exitbtn);
    }

    private void buttonLayout(Button button) {
        button.setPrefWidth(100);
        button.setPrefHeight(30);
    }

    Button getPlaybtn() {
        return playbtn;
    }

    Button gethScorebtn() {
        return hScorebtn;
    }

    Button getExitbtn() {
        return exitbtn;
    }

}
