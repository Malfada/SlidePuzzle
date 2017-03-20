package sample.view.highScores;

import sample.model.SchuifpuzzelModel;

/**
 * Created by Gebruiker on 12-3-2017.
 */
public class HighScorePresenter {
    private SchuifpuzzelModel model;
    private HighScoreView highScoreView;

    public HighScorePresenter(SchuifpuzzelModel model, HighScoreView view) {
        this.model = model;
        this.highScoreView = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

    }

    private void updateView(){
        int lijst = model.getScoreHandler().getLijstLengte();
        for(int i = 0; i<lijst && i<10; i++){
            highScoreView.getLabelListColomn0().get(i).setText(model.getScoreHandler().getPlayerNameFromList(i));
            highScoreView.getLabelListColomn1().get(i).setText(model.getScoreHandler().getPlayersClicksFromList(i));
            highScoreView.getLabelListColomn2().get(i).setText(model.getScoreHandler().getPlayersTimeFromList(i));
            highScoreView.getLabelListColomn3().get(i).setText(model.getScoreHandler().getDatumGamePlayed(i));
        }

    }
}
