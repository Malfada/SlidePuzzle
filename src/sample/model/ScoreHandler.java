package sample.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ScoreHandler {
    private static final String SCORES_FILE_DIRECTORY = "Scores.txt";
    private ArrayList<String> scoreStringsFromFile;
    private ArrayList<PlayerScore> allScores;
    private Datum datum = new Datum();

    ScoreHandler(){
        setEntriesFileIntoList();
    }

    private void setEntriesFileIntoList(){
        this.scoreStringsFromFile = new ArrayList<>();
        Path path = Paths.get(SCORES_FILE_DIRECTORY);
        try {
            List<String> listLinesFromFile = Files.readAllLines(path);
            for (int i = 0; i < listLinesFromFile.size(); i++){
                scoreStringsFromFile.add(listLinesFromFile.get(i));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void writeScoreStringsToFile(ArrayList<String> scoreStringList){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SCORES_FILE_DIRECTORY))) {
            for(String string : scoreStringList){
                bw.write(string);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addScoreToScoreList(String scoreString){
        String scoreAndDate = scoreString + "#" + datum.format();
        scoreStringsFromFile.add(scoreAndDate);
        writeScoreStringsToFile(scoreStringsFromFile);
    }

    public void makeScoreList(){
        allScores = new ArrayList<>();
        for (int i = 0; i< scoreStringsFromFile.size(); i++) {
            String s = scoreStringsFromFile.get(i);
            String[] parts = s.split("#");
            PlayerScore playerScore = new PlayerScore(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
            allScores.add(playerScore);
        }
    }

    public String convertToMinAndSec(int timeInMSec){
        int sec = (timeInMSec /1000) %60;
        int min = (timeInMSec /60000) %60;
        return String.format("%02d:%02d", min, sec);

    }

    public void sortScoreList(){
        this.allScores.sort(PlayerScore::compareTo);
    }

    public int getNrOfEntries(){
        return this.scoreStringsFromFile.size();
    }

    public String getPlayerNameFromList(int i){
        return allScores.get(i).getNamePlayer();
    }

    public String getPlayersClicksFromList(int i){
        return "" + allScores.get(i).getClickCount();
    }

    public String getPlayersTimeFromList(int i){
        return "" + convertToMinAndSec(allScores.get(i).getTime());
    }

    public String getDatumGamePlayed(int i){
        return "" + allScores.get(i).getDatum();
    }

}

