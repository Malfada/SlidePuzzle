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
            final String playerName = scoreDisplayView.getNaamTxtField().getText();
            final String clickCount = scoreDisplayView.getClicksValueLbl().getText();
            final String time = scoreDisplayView.getTestTimeLbl().getText();
            final String combinedString = playerName + "#" + clickCount + "#" + time;
            model.getScoreHandler().addScoreToScoreList(combinedString);
            model.getScoreHandler().makeScoreList();
            model.getScoreHandler().sortScoreList();


            HighScoreView highScoreView = new HighScoreView(model.getNrOfEntries());
            HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
            scoreDisplayView.getScene().setRoot(highScoreView);
            highScoreView.getScene().getWindow().sizeToScene();
        });
    }

    private void updateView(){
        scoreDisplayView.getClicksValueLbl().setText(Integer.toString(model.getClickCount()));
        scoreDisplayView.getTestTimeLbl().setText(model.getTimer().getMilliSecPlayed());
        scoreDisplayView.getTimeValueLbl().setText(model.getScoreHandler().convertToMinAndSec(Integer.parseInt(model.getTimer().getMilliSecPlayed())));
    }


}
