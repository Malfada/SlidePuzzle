package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.SlidePuzzleModel;
import sample.view.startscherm.StartScreenPresenter;
import sample.view.startscherm.StartScreenView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SlidePuzzleModel model = new SlidePuzzleModel();
        StartScreenView view = new StartScreenView();
        StartScreenPresenter presenter = new StartScreenPresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("css/stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Schuifpuzzel");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
