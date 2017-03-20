package sample.view.highScores;

import sample.model.SlidePuzzleModel;
import sample.view.startscherm.StartScreenPresenter;
import sample.view.startscherm.StartScreenView;

public class HighScorePresenter {
    private SlidePuzzleModel model;
    private HighScoreView highScoreView;

    public HighScorePresenter(SlidePuzzleModel model, HighScoreView view) {
        this.model = model;
        this.highScoreView = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){
        highScoreView.getReturnBtn().setOnAction(event -> {
            StartScreenView startScreenView = new StartScreenView();
            StartScreenPresenter startScreenPresenter = new StartScreenPresenter(model , startScreenView);
            highScoreView.getScene().setRoot(startScreenView);
            startScreenView.getScene().getWindow().sizeToScene();
        });

    }

    private void updateView(){
        int nrOfEntries = model.getScoreHandler().getNrOfEntries();
        for(int i = 0; i<nrOfEntries && i<10; i++){
            highScoreView.getNameLblList().get(i).setText(model.getScoreHandler().getPlayerNameFromList(i));
            highScoreView.getClickLblList().get(i).setText(model.getScoreHandler().getPlayersClicksFromList(i));
            highScoreView.getTimeLblList().get(i).setText(model.getScoreHandler().getPlayersTimeFromList(i));
            highScoreView.getDateLblList().get(i).setText(model.getScoreHandler().getDatumGamePlayed(i));
        }

    }
}
