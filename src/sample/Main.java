package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.SchuifpuzzelModel;
import sample.view.startscherm.StartschermPresenter;
import sample.view.startscherm.StartschermView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SchuifpuzzelModel model = new SchuifpuzzelModel();
        StartschermView view = new StartschermView();
        StartschermPresenter presenter = new StartschermPresenter(model, view);
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        //to do windowHandlers
        primaryStage.setTitle("Schuifpuzzel");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
