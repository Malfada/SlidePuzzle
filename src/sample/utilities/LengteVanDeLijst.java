package sample.utilities;

import sample.model.ScoreHandler;

/**
 * Created by Dynah Hemeleers on 18/03/2017.
 */
public class LengteVanDeLijst {
    ScoreHandler model = new ScoreHandler();
    int lengteVanDeLijst;

    public int setLengteVanDeLijst(){
        return lengteVanDeLijst = model.getLijst().size();
    }
}
