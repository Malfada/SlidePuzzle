package sample.view.scoreWeergave;

import sample.model.SlidePuzzleModel;
import sample.view.highScores.HighScorePresenter;
import sample.view.highScores.HighScoreView;

public class ScoreDisplayPresenter {
    private SlidePuzzleModel model;
    private ScoreDisplayView scoreDisplayView;

    public ScoreDisplayPresenter(SlidePuzzleModel model, ScoreDisplayView view ){
        this.model = model;
        this.scoreDisplayView = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

        scoreDisplayView.getOkBtn().setOnAction(event -> {
            String playerName = scoreDisplayView.getNameTxtField().getText();
            model.setPlayerScore(playerName);
            model.getScoreHandler().addScoreToScoreList(model.getPlayerScore());

            HighScoreView highScoreView = new HighScoreView(model.getNrOfEntries());
            HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
            scoreDisplayView.getScene().setRoot(highScoreView);
            highScoreView.getScene().getWindow().sizeToScene();
        });
    }

    private void updateView(){
        scoreDisplayView.getClicksValueLbl().setText(Integer.toString(model.getClickCount()));
        scoreDisplayView.getTimeValueLbl().setText(model.getTimer().convertToMinAndSecString());
    }

}
