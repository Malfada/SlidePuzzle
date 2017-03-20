package sample.view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import sample.model.SchuifpuzzelModel;
import sample.view.scoreWeergave.ScoreWeergavePresenter;
import sample.view.scoreWeergave.ScoreWeergaveView;

/**
 * Created by Gebruiker on 12-3-2017.
 */
public class GamePresenter {
    private SchuifpuzzelModel model;
    private GameView view;
    private Timeline stopwatchTimeline;


    public GamePresenter(SchuifpuzzelModel model, GameView view) {
        this.model = model;
        this.view = view;
        setIndexHole();
        model.doRandomMoves();
        setupTimeline(); //Nakijken!!
        stopwatchTimeline.play();
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

        for(int i = 0 ; i < model.SIZE ; i++) {
            final int index = i;
            view.getButtonArrayList().get(index).setOnAction(event -> {
                setIndexHole();
                //view.setFocusHole(getIndexHole());
                if (model.canMove(index)) {
                    move(index);
                } else {
                    model.playError();
                }
                if (model.isSolved()) {
                    goScoreView();
                }
            });
        }
        view.getGridPane().setOnKeyPressed(event -> {
            setIndexHole();
            //view.setFocusHole(getIndexHole());
            KeyCode keyPressed = event.getCode();
            int movingToIndex;
            if (keyPressed == KeyCode.UP || keyPressed == KeyCode.KP_UP) {
                movingToIndex = getIndexHole()- model.DIMENSION;
                if(model.canMove(movingToIndex)) {
                    move(movingToIndex);
                } else {model.playError();}
            } else if (keyPressed == KeyCode.DOWN || keyPressed == KeyCode.KP_DOWN) {
                movingToIndex = getIndexHole()+ model.DIMENSION;
                if(model.canMove(movingToIndex)) {
                    move(movingToIndex);
                } else {model.playError();}
            } else if (keyPressed == KeyCode.LEFT || keyPressed == KeyCode.KP_LEFT) {
                movingToIndex = getIndexHole()- 1;
                if(model.canMove(movingToIndex)) {
                    move(movingToIndex);
                } else {model.playError();}
            } else if (keyPressed == KeyCode.RIGHT || keyPressed == KeyCode.KP_RIGHT) {
                movingToIndex = getIndexHole()+ 1;
                if(model.canMove(movingToIndex)) {
                    move(movingToIndex);
                }else {model.playError();}
            }
            if (model.isSolved()) {
                goScoreView();
                //view.getClicksText().setText("solved"); //testing if it works
                //TODO go to score view
            }
        });
    }

    private void updateView(){
        view.getTimerView().getHmsmList(0).setText(String.format("%02d", this.model.getTimer().getHours()));
        view.getTimerView().getHmsmList(2).setText(String.format("%02d", this.model.getTimer().getMinutes()));
        view.getTimerView().getHmsmList(4).setText(String.format("%02d", this.model.getTimer().getSeconds()));
        view.getTimerView().getHmsmList(6).setText(String.format("%03d", this.model.getTimer().getMilisec()));
    }

    private void goScoreView() {
        stopwatchTimeline.stop();
        model.getTimer().getMilisecPlayed();
        model.getClickCount();

        ScoreWeergaveView scoreWeergaveView = new ScoreWeergaveView();
        ScoreWeergavePresenter scoreWeergavePresenter = new ScoreWeergavePresenter(model, scoreWeergaveView);
        view.getScene().setRoot(scoreWeergaveView);
        scoreWeergaveView.getScene().getWindow().sizeToScene();
    }

    private void setIndexHole() {
        model.setIndexHole(view.getImageViewArrayList(), view.getImageArrayList());
    }

    private int getIndexHole() {
        return model.getIndexHole();
    }

    private void move(int indexPressed) {
        model.move(indexPressed);
        model.incrementClickCount();
        view.getClicksText().setText("Clicks: " + model.getClickCount());
    }

    //Nakijken!!
    private void setupTimeline() {
        stopwatchTimeline = new Timeline();
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        updateClockSpeed();
    }

    //Nakijken!!
    private void updateClockSpeed() {
        stopwatchTimeline.getKeyFrames().clear();
        stopwatchTimeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(this.model.getTimer().getTickDurationMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getTimer().tick();
                updateView();
            }
        }));
    }


}
