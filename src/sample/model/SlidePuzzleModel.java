package sample.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class SlidePuzzleModel {
    private Timer timer = new Timer();
    private ScoreHandler scoreHandler = new ScoreHandler();
    public static final int SIZE = 16;
    public static final int DIMENSION = 4;
    private static final int EMPTY_IMG_NUMBER = 3;
    private int indexHole;
    private int clickCount = 0;
    private ArrayList<ImageView> iVL;        //List of references to the ImageViews
    private ArrayList<Image> iL;             //                          Images
    private ArrayList<Boolean> solved;       //List states which img is in the correct imgView
    private String error = "error.mp3";
    private String clock = "Clock.mp3";


    public void setIndexHole(ArrayList<ImageView> imageViewList, ArrayList<Image> imageList) {
        this.iL = imageList;
        this.iVL = imageViewList;
        for (int i=0 ; i < SIZE ; i++) {
            ImageView imageViewOnIndexI = iVL.get(i);                   //temp store iterated ImageView
            Image emptyImg = iL.get(EMPTY_IMG_NUMBER);                  //temp store empty img
            if(imageViewOnIndexI.getImage().equals(emptyImg)) {         //compare img in stored ImageView with empty img
                indexHole = i;                                          //store index if same
            }
        }
    }

    public void incrementClickCount() {
        this.clickCount++;
    }

    public void move(int indexButtonPressed) {
        Image tempImage = iVL.get(indexButtonPressed).getImage();       //store img clicked
        iVL.get(indexButtonPressed).setImage(iL.get(EMPTY_IMG_NUMBER)); //put empty img into clicked
        iVL.get(indexHole).setImage(tempImage);                         //put stored img into place where empty img was
    }

    public boolean canMove(int indexButtonPressed) {
        if (indexButtonPressed < 0 || indexButtonPressed >= SIZE) {
            return false;                                   // No such position
        }
        int diff = indexHole - indexButtonPressed;
        if (diff == -1) {                                   // Slide tile left (hole goes right)
            return indexButtonPressed % DIMENSION != 0;     // ... unless tile is on left edge
        } else if (diff == +1) {                            // Slide tile right (hole goes left)
            return indexHole % DIMENSION != 0;              // ... unless hole is on left edge
        } else {
            return Math.abs(diff) == DIMENSION;             // Slide vertically
        }
    }

    public void doRandomMoves(){
        int numberOfMoves = 1000;
        Random rand = new Random();
        int[] neighborOffsets = { -DIMENSION, +DIMENSION, -1, +1 }; // up down left right
        while (numberOfMoves --> 0) {
            int neighbor;
            do {
                neighbor = getIndexHole() + neighborOffsets[rand.nextInt(neighborOffsets.length)];
            } while (!this.canMove(neighbor));
            this.move(neighbor);
            setIndexHole(iVL, iL);
        }
    }

    private void setSolved() {
        this.solved = new ArrayList<>();
        for (int index = 0 ; index < SIZE ; index++) {
            Boolean booleanOfIndex = iVL.get(index).getImage().equals(iL.get(index));
            this.solved.add(booleanOfIndex);
        }
    }

    public Boolean isSolved() {
        setSolved();
        for (Boolean aBoolean : solved ) {
            if (!aBoolean) { return false; }
        }
        return true;
    }

    public void playError() {
        playMedia(error);
    }

    public void playClock() {
        playMedia(clock);
    }

    private void playMedia(String dir) {
        Media media = new Media(new File(dir).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }

    public int getClickCount() {
        return clickCount;
    }

    public int getIndexHole() {
        return indexHole;
    }

    public ScoreHandler getScoreHandler(){
        return scoreHandler;
    }

    public int getNrOfEntries() {
        return this.scoreHandler.getNrOfEntries();
    }

    public Timer getTimer(){
        return timer;
    }
}
