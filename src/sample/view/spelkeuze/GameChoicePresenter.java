package sample.view.spelkeuze;

import sample.model.SlidePuzzleModel;
import sample.view.game.GamePresenter;
import sample.view.game.GameView;

import static sample.view.spelkeuze.GameChoiceView.NR_OF_GAMES;

public class GameChoicePresenter {
    private SlidePuzzleModel model;
    private GameChoiceView view;

    public GameChoicePresenter(SlidePuzzleModel model, GameChoiceView view){
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers(){
        for (int i = 0; i < NR_OF_GAMES ; i++) {
            final int index = i;
            view.getGameBtnList().get(index).setOnAction(event -> {
                GameView gameView = new GameView(index + 1);
                GamePresenter gamePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
            });
        }
    }

}