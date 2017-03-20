package sample.view.spelkeuze;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.model.SlidePuzzleModel;
import sample.view.game.GamePresenter;
import sample.view.game.GameView;

public class GameChoicePresenter {
    private SlidePuzzleModel model;
    private GameChoiceView view;

    public GameChoicePresenter(SlidePuzzleModel model, GameChoiceView view){
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers(){
        view.getSpel1().setOnAction(event -> {
            GameView gameView = new GameView(1);
            GamePresenter gamePresenter = new GamePresenter(model, gameView);
            view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });

        view.getSpel2().setOnAction(event -> {
            GameView gameView = new GameView(2);
            GamePresenter gamePresenter = new GamePresenter(model, gameView);
            view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });

        view.getSpel3().setOnAction(event -> {
            GameView gameView = new GameView(3);
            GamePresenter gamePresenter = new GamePresenter(model, gameView);
            view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });
    }

}