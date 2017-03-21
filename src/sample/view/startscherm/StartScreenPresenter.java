package sample.view.startscherm;

import javafx.stage.Stage;
import sample.model.SlidePuzzleModel;
import sample.view.highScores.HighScorePresenter;
import sample.view.highScores.HighScoreView;
import sample.view.spelkeuze.GameChoicePresenter;
import sample.view.spelkeuze.GameChoiceView;

public class StartScreenPresenter {
    private SlidePuzzleModel model;
    private StartScreenView startScreenView;

    public StartScreenPresenter(SlidePuzzleModel model, StartScreenView view) {
        this.model = model;
        this.startScreenView = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        startScreenView.getPlayBtn().setOnAction(event -> {
            GameChoiceView gameChoiceView = new GameChoiceView();
            GameChoicePresenter gameChoicePresenter = new GameChoicePresenter(model, gameChoiceView);
            startScreenView.getScene().setRoot(gameChoiceView);
            gameChoiceView.getScene().getWindow().sizeToScene();
        });

        startScreenView.gethScoreBtn().setOnAction(event -> {
            model.getScoreHandler().makeScoreList();

            HighScoreView highScoreView = new HighScoreView(model.getNrOfEntries());
            HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
            startScreenView.getScene().setRoot(highScoreView);
            highScoreView.getScene().getWindow().sizeToScene();
        });

        startScreenView.getExitBtn().setOnAction(event -> {
            Stage stage = (Stage) startScreenView.getExitBtn().getScene().getWindow();
            stage.close();
        });
    }


}
