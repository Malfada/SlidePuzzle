package sample.model;

public class PlayerScore implements Comparable<PlayerScore> {
    private final String namePlayer;
    private final int clickCount;
    private final int time;
    private final String datum;
    //private String score;

    PlayerScore(String namePlayer, int clickCount, int time, String datum) {
        this.namePlayer = namePlayer;
        this.clickCount = clickCount;
        this.time = time;
        this.datum = datum;
        //setPlayerScore();
    }

    /*public void setPlayerScore() {
        score = naamSpeler + " " + aantalClicks + " " + tijd;
    } */


    public int compareTo(PlayerScore otherScore){
        if(clickCount == otherScore.getClickCount() && time > otherScore.getTime()){
            return 1;
            //verplaats 1e naar 2e (doe dit in Model!)

        }else if(clickCount > otherScore.getClickCount()){
            return 1;
            //verplaats 1e naar 2e (doe dit in Model!)

        }else if(clickCount == otherScore.getClickCount() && time == otherScore.getTime()) {
            return 0;
        }else {
            return -1;
        }
        //verglijk volgende 2 (doe dit in Model!)
    }


    String getNamePlayer(){
        return namePlayer;
    }

    int getClickCount(){
        return clickCount;
    }

    int getTime(){
        return time;
    }

    String getDatum(){
        return datum;
    }

    //public String getScore(){return score;}
}
