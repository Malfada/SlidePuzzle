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
        startScreenView.getPlaybtn().setOnAction(event -> {
            GameChoiceView gameChoiceView = new GameChoiceView();
            GameChoicePresenter gameChoicePresenter = new GameChoicePresenter(model, gameChoiceView);
            startScreenView.getScene().setRoot(gameChoiceView);
            gameChoiceView.getScene().getWindow().sizeToScene();
        });

        startScreenView.gethScorebtn().setOnAction(event -> {
            model.getScoreHandler().makeScoreList();
            model.getScoreHandler().sortScoreList();

            HighScoreView highScoreView = new HighScoreView(model.getNrOfEntries());
            HighScorePresenter highScorePresenter = new HighScorePresenter(model, highScoreView);
            startScreenView.getScene().setRoot(highScoreView);
            highScoreView.getScene().getWindow().sizeToScene();
        });

        //!!!!Even om te checken moet terug aangepast worden!!!!!!!
        startScreenView.getExitbtn().setOnAction(event -> {
            Stage stage = (Stage) startScreenView.getExitbtn().getScene().getWindow();
            stage.close();


            //indien we nieuwe stage zouden willen maken
            //ScoreDisplayView scoreWeergaveView = new ScoreDisplayView();
            //ScoreDisplayPresenter scoreWeergavePresenter = new ScoreDisplayPresenter(model, scoreWeergaveView);
            //Stage scoreStage = new Stage();
            //scoreStage.initOwner(startScreenView.getScene().getWindow());
            //scoreStage.initModality(Modality.APPLICATION_MODAL);
            //scoreStage.setScene(new Scene(scoreWeergaveView));
            //scoreStage.showAndWait();
        });
    }


}
