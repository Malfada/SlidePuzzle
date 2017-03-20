package sample.view.game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class GameView extends BorderPane{
    private TimerView TimerView;
    private static final int SIZE = 16;                 //number of images in the grid
    private static final int DIMENSION = 4;             //H and V dimension of the grid
    private static final String IMAGE_PACKAGE = "sample/view/images/game";
    private int gameNr;
    private Label clicksText;
    private GridPane gridPane;
    private ArrayList<Button> buttonArrayList;          //List of references to the Buttons
    private ArrayList<ImageView> imageViewArrayList;    //                          ImageViews
    private ArrayList<Image> imageArrayList;            //                          Images
    private ArrayList<String> urlArrayList;             //                          urls


    public GameView(int game) {
        setGameNr(game);
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.TimerView = new TimerView();
        this.clicksText = new Label("Clicks: 0");
        setGridPane();
    }

    private void layoutNodes() {
        this.setPadding(new Insets(10)); //????
        setBottom(TimerView);
        this.setTop(clicksText);
        this.setCenter(gridPane);
    }

    private void setGameNr(int game) {
        this.gameNr = game;
    }

    private void setGridPane() {                        //puts all the buttons created into the GridPane
        this.setButtonArrayList();                      //going from left to right row by row
        this.gridPane = new GridPane();
        int indexOfCurrentElement = 0;
        for(int row = 0; row < DIMENSION; row++) {
            for(int column = 0; column < DIMENSION; column++) {
                Button tempButton = buttonArrayList.get(indexOfCurrentElement);
                gridPane.add(tempButton, column , row);
                indexOfCurrentElement++;
            }
        }
    }

    private void setButtonArrayList() {                 //puts all the ImageViews created into the respective Buttons
        this.setImageViewArrayList();                   //and puts the Buttons into the buttonList
        this.buttonArrayList = new ArrayList<>();
        for(int i = 0 ; i < SIZE ; i++) {
            Button button = new Button("" ,imageViewArrayList.get(i));
            button.setPadding(new Insets(5));
            button.defaultButtonProperty().bind(button.focusedProperty());
            this.buttonArrayList.add(button);
        }
    }

    private void setImageViewArrayList() {              //puts all the Images created into the respective ImageViews
        this.setImageArrayList();                       //and puts the imagesViews into the imageViewList
        this.imageViewArrayList = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            ImageView imageView = new ImageView(imageArrayList.get(i));
            this.imageViewArrayList.add(imageView);
        }
    }

    private void setImageArrayList() {                  //puts all the ImageUrls created into the respective Images
        this.setUrlArrayList();                         //and puts the images into the imageList
        this.imageArrayList = new ArrayList<>();
        for(int i = 0 ; i < SIZE ; i++) {
            Image image = new Image(this.urlArrayList.get(i));
            this.imageArrayList.add(image);
        }
    }

    private void setUrlArrayList() {                    //Creates all imgUrls and puts them into the urlList
        this.urlArrayList = new ArrayList<>();
        String dir = IMAGE_PACKAGE + gameNr + "/nr_%d.gif";
        for(int i = 1 ; i <= SIZE ; i++) {
            String url = String.format(dir, i);
            this.urlArrayList.add(url);
        }
    }

    ArrayList<Image> getImageArrayList() {
        return imageArrayList;
    }

    ArrayList<ImageView> getImageViewArrayList() {
        return imageViewArrayList;
    }

    ArrayList<Button> getButtonArrayList() {
        return buttonArrayList;
    }

    Label getClicksText() {
        return clicksText;
    }

    GridPane getGridPane() {
        return gridPane;
    }

    TimerView getTimerView(){
        return TimerView;
    }

}







