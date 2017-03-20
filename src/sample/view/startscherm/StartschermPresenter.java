package sample.view.startscherm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sample.model.SchuifpuzzelModel;
import sample.view.highScores.HighScorePresenter;
import sample.view.highScores.HighScoreView;
import sample.view.scoreWeergave.ScoreWeergavePresenter;
import sample.view.scoreWeergave.ScoreWeergaveView;
import sample.view.spelkeuze.SpelkeuzePresenter;
import sample.view.spelkeuze.SpelkeuzeView;

public class StartschermPresenter {
    private SchuifpuzzelModel model;
    private StartschermView startschermView;

    public StartschermPresenter(SchuifpuzzelModel model, StartschermView view) {
        this.model = model;
        this.startschermView = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        startschermView.getPlaybtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelkeuzeView spelkeuzeView = new SpelkeuzeView();
                SpelkeuzePresenter spelkeuzePresenter = new SpelkeuzePresenter(model, spelkeuzeView);
                startschermView.getScene().setRoot(spelkeuzeView);
                spelkeuzeView.getScene().getWindow().sizeToScene();
            }
        });

        startschermView.gethScorebtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getScoreHandler().makeScoreList();
                model.getScoreHandler().rangschikScoreLijst();

                HighScoreView highScoreView = new HighScoreView();
                HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
                startschermView.getScene().setRoot(highScoreView);
                highScoreView.getScene().getWindow().sizeToScene();
            }
        });

        //!!!!Even om te checken moet terug aangepast worden!!!!!!!
        startschermView.getExitbtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {



                //indien we nieuwe stage zouden willen maken
                //ScoreWeergaveView scoreWeergaveView = new ScoreWeergaveView();
                //ScoreWeergavePresenter scoreWeergavePresenter = new ScoreWeergavePresenter(model, scoreWeergaveView);
                //Stage scoreStage = new Stage();
                //scoreStage.initOwner(startschermView.getScene().getWindow());
                //scoreStage.initModality(Modality.APPLICATION_MODAL);
                //scoreStage.setScene(new Scene(scoreWeergaveView));
                //scoreStage.showAndWait();
            }
        });
    }


}
