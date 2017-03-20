package sample.view.highScores;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import sample.utilities.LengteVanDeLijst;

import java.util.ArrayList;

/**
 * Created by Gebruiker on 12-3-2017.
 */
public class HighScoreView extends GridPane {
    private ArrayList<Label> LabelListColomn0;
    private ArrayList<Label> LabelListColomn1;
    private ArrayList<Label> LabelListColomn2;
    private ArrayList<Label> LabelListColomn3;
    private LengteVanDeLijst lengteVanDeLijst;
    private int lengte;

    public HighScoreView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.lengteVanDeLijst = new LengteVanDeLijst();
        this.lengte = lengteVanDeLijst.setLengteVanDeLijst();
        setLabelListColomn0();
        setLabelListColomn1();
        setLabelListColomn2();
        setLabelListColomn3();
    }

    private void layoutNodes(){
        this.setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(10);

        for(int i = 0; i<lengte && i<10; i++){
            this.add(LabelListColomn0.get(i),0, i);
            this.add(LabelListColomn1.get(i), 1, i);
            this.add(LabelListColomn2.get(i), 2, i);
            this.add(LabelListColomn3.get(i), 3, i);
        }
    }

    private ArrayList setLabelListColomn0(){
        this.LabelListColomn0 = new ArrayList<>();
        for(int i = 0; i<lengte; i++){
            Label label = new Label();
            LabelListColomn0.add(label);
        } return LabelListColomn0;
    }
    private ArrayList setLabelListColomn1(){
        this.LabelListColomn1 = new ArrayList<>();
        for(int i = 0; i<lengte; i++){
            Label label = new Label();
            LabelListColomn1.add(label);
        } return LabelListColomn1;
    }
    private ArrayList setLabelListColomn2(){
        this.LabelListColomn2 = new ArrayList<>();
        for(int i = 0; i<lengte; i++){
            Label label = new Label();
            LabelListColomn2.add(label);
        } return LabelListColomn2;
    }
    private ArrayList setLabelListColomn3(){
        this.LabelListColomn3 = new ArrayList<>();
        for(int i = 0; i<lengte; i++){
            Label label = new Label();
            LabelListColomn3.add(label);
        } return LabelListColomn3;
    }

    ArrayList<Label> getLabelListColomn0(){
        return LabelListColomn0;
    }
    ArrayList<Label> getLabelListColomn1(){
        return LabelListColomn1;
    }
    ArrayList<Label> getLabelListColomn2(){
        return LabelListColomn2;
    }
    ArrayList<Label> getLabelListColomn3(){
        return LabelListColomn3;
    }

}
