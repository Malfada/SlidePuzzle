package sample.view.spelkeuze;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class GameChoiceView extends VBox{
    private ArrayList<Button> gameBtnList;
    private Label titleLbl;
    public static final int NR_OF_GAMES = 3;

    public GameChoiceView(){
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.titleLbl = new Label("Pick game");
        this.gameBtnList = new ArrayList<>();
        for (int i = 1; i <= NR_OF_GAMES ; i++) {
            Image preview = new Image("sample/view/images/game" + i + "/preview.jpg");
            ImageView iv = new ImageView(preview);
            iv.setFitWidth(100);
            iv.setPreserveRatio(true);
            Button btn = new Button("", iv);
            btn.defaultButtonProperty().bind(btn.focusedProperty());
            gameBtnList.add(btn);
        }
    }

    private void layoutNodes() {
        this.getChildren().add(0, titleLbl);
        for (int i = 0; i < NR_OF_GAMES ; i++) {
            Button btn = this.gameBtnList.get(i);
            this.buttonLayout(btn);
            this.getChildren().add(i+1, btn);
        }
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.setPrefWidth(200);
    }

    private void buttonLayout(Button button) {
        button.setPrefWidth(100);
        button.setPrefHeight(30);
    }

    ArrayList<Button> getGameBtnList() {
        return gameBtnList;
    }

}