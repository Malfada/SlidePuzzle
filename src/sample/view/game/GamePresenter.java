package sample.view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import sample.model.SlidePuzzleModel;
import sample.view.scoreWeergave.ScoreDisplayPresenter;
import sample.view.scoreWeergave.ScoreDisplayView;

import static sample.model.SlidePuzzleModel.*;
import static sample.model.SlidePuzzleModel.SIZE;

public class GamePresenter {
    private SlidePuzzleModel model;
    private GameView view;
    private Timeline stopwatchTimeline, clockTimeline;


    public GamePresenter(SlidePuzzleModel model, GameView view) {
        this.model = model;
        this.view = view;
        setIndexHole();
        model.doRandomMoves();
        setupTimeline();
        stopwatchTimeline.play();
        clockTimeline.play();
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){

        for(int i = 0; i < SIZE; i++) {
            final int index = i;
            view.getButtonArrayList().get(index).setOnAction(event -> {
                setIndexHole();
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
            KeyCode keyPressed = event.getCode();
            int movingToIndex;
            if (keyPressed == KeyCode.UP || keyPressed == KeyCode.KP_UP) {
                movingToIndex = getIndexHole()- DIMENSION;
                if(model.canMove(movingToIndex)) {
                    move(movingToIndex);
                } else {model.playError();}
            } else if (keyPressed == KeyCode.DOWN || keyPressed == KeyCode.KP_DOWN) {
                movingToIndex = getIndexHole()+ DIMENSION;
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
            }
        });
    }

    private void updateView(){
        view.getTimerView().getHmsmList(0).setText(String.format("%02d", this.model.getTimer().getHours()));
        view.getTimerView().getHmsmList(2).setText(String.format("%02d", this.model.getTimer().getMinutes()));
        view.getTimerView().getHmsmList(4).setText(String.format("%02d", this.model.getTimer().getSeconds()));
        view.getTimerView().getHmsmList(6).setText(String.format("%03d", this.model.getTimer().getMilliSec()));
    }

    private void goScoreView() {
        stopwatchTimeline.stop();
        clockTimeline.stop();
        ScoreDisplayView scoreDisplayView = new ScoreDisplayView();
        ScoreDisplayPresenter scoreDisplayPresenter = new ScoreDisplayPresenter(model, scoreDisplayView);
        view.getScene().setRoot(scoreDisplayView);
        scoreDisplayView.getScene().getWindow().sizeToScene();
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
        clockTimeline = new Timeline();
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        clockTimeline.setCycleCount(Animation.INDEFINITE);
        updateClockSpeed();
    }

    //Nakijken!!
    private void updateClockSpeed() {
        stopwatchTimeline.getKeyFrames().clear();
        stopwatchTimeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(1), event -> {
                    model.getTimer().tick();
                    updateView();
                }));
        clockTimeline.getKeyFrames().clear();
        clockTimeline.getKeyFrames().add(new KeyFrame(
                Duration.seconds(1), event -> model.playClock()));


    }


}
