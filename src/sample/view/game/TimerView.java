package sample.view.game;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

class TimerView extends GridPane {
    private static final int HMSM = 4;
    private ArrayList<Label> hmsmList;

    TimerView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.hmsmList = new ArrayList<>();
        for(int i = 0 ; i < HMSM ; i++) {
            Label timeLabel = new Label();
            Label colon = new Label(":");
            this.hmsmList.add(timeLabel);
            this.hmsmList.add(colon);
        }
        this.hmsmList.remove(hmsmList.size()-1);
    }

    private void layoutNodes() {
        for(int i = 0; i < hmsmList.size() ; i++) {
            this.add(this.hmsmList.get(i), i, 0);
        }
    }

    Label getHmsmList(int i) {
        return hmsmList.get(i);
    }

}
