package sample.view.scoreWeergave;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.model.SchuifpuzzelModel;
import sample.view.highScores.HighScorePresenter;
import sample.view.highScores.HighScoreView;

/**
 * Created by Dynah Hemeleers on 14/03/2017.
 */
public class ScoreWeergavePresenter {
    private SchuifpuzzelModel model;
    private ScoreWeergaveView scoreWeergaveView;

    public ScoreWeergavePresenter(SchuifpuzzelModel model, ScoreWeergaveView view ){
        this.model = model;
        this.scoreWeergaveView = view;
        addEventHandlers();
        updateView();
    }


    private void addEventHandlers(){

        scoreWeergaveView.getOkBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final String naamSpeler = scoreWeergaveView.getNaamTxtField().getText();
                final String aantalClicks = scoreWeergaveView.getClicksValueLbl().getText();
                final String tijd = scoreWeergaveView.getTestTimeLbl().getText();
                final String tekstVeldInhoud = naamSpeler + "#" + aantalClicks + "#" + tijd;
                model.getScoreHandler().steekTekstInLijst(tekstVeldInhoud);
                model.getScoreHandler().makeScoreList();
                model.getScoreHandler().rangschikScoreLijst();


                HighScoreView highScoreView = new HighScoreView();
                HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
                scoreWeergaveView.getScene().setRoot(highScoreView);
                highScoreView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView(){
        scoreWeergaveView.getClicksValueLbl().setText(Integer.toString(model.getClickCount()));
        scoreWeergaveView.getTestTimeLbl().setText(model.getTimer().getMilisecPlayed());
        scoreWeergaveView.getTimeValueLbl().setText(model.getScoreHandler().convertToMinAndSec(Integer.parseInt(model.getTimer().getMilisecPlayed())));
    }


}
