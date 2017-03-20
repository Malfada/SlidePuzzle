package sample.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dynah Hemeleers on 15/03/2017.
 */
public class ScoreHandler {
    private Path path = Paths.get( "../" + File.separator + "SlidePuzzle" + File.separator + "TekstFile.txt");
    //private String filename = path.toString();
    private ArrayList<String> tekstLijst;
    private ArrayList<PlayerScore> allScores;
    private Datum datum = new Datum();

    public ScoreHandler(){
        haalTekstOp();
    }

    private void haalTekstOp(){
        this.tekstLijst = new ArrayList<>();
        try {
            List<String> lijstUitBestand = Files.readAllLines(path);
            for (int i = 0; i < lijstUitBestand.size(); i++){
                tekstLijst.add(lijstUitBestand.get(i));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void schrijfTekstInDocument(ArrayList<String> tekstLijst){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("TekstFile.txt"))) {
            for(String string : tekstLijst){
                bw.write(string);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void steekTekstInLijst(String tekstUitTextveld){
        String tekst = tekstUitTextveld + "#" + datum.format();
        tekstLijst.add(tekst);
        schrijfTekstInDocument(tekstLijst);
    }

    public String haalTekstUitLijst(int i){
        String tekst = tekstLijst.get(i);
        return tekst;
    }

    public void makeScoreList(){
        allScores = new ArrayList<>();
        for (int i =0; i<tekstLijst.size(); i++) {
            String s = tekstLijst.get(i);
            String[] parts = s.split("#");
            PlayerScore playerScore = new PlayerScore(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
            allScores.add(playerScore);
        }
    }

    public String convertToMinAndSec(int parth2){
        int milisecDoc = parth2;
        int seconden = (milisecDoc/1000) %60;
        int minutes = (milisecDoc/60000) %60;
        return String.format("%02d:%02d", minutes, seconden);

    }

    public void rangschikScoreLijst(){
        this.allScores.sort(PlayerScore::compareTo);
    }

    public ArrayList getLijst(){
        return tekstLijst;
    }

    public int getLijstLengte(){
        return this.tekstLijst.size();
    }

    public String getPlayerNameFromList(int i){
        return allScores.get(i).getNaamSpeler();
    }

    public String getPlayersClicksFromList(int i){
        return "" + allScores.get(i).getAantalClicks();
    }

    public String getPlayersTimeFromList(int i){
        return "" + convertToMinAndSec(allScores.get(i).getTijd());
    }

    public String getDatumGamePlayed(int i){
        return "" + allScores.get(i).getDatum();
    }


}

