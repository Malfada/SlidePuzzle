package sample.model;

/**
 * Created by Dynah Hemeleers on 15/03/2017.
 */
public class PlayerScore implements Comparable<PlayerScore> {
    private final String namePlayer;
    private final int amountClicks;
    private final int time;
    private final String datum;
    //private String score;

    public PlayerScore(String namePlayer, int amountClicks, int time, String datum) {
        this.namePlayer = namePlayer;
        this.amountClicks = amountClicks;
        this.time = time;
        this.datum = datum;
        //setPlayerScore();
    }

    /*public void setPlayerScore() {
        score = naamSpeler + " " + aantalClicks + " " + tijd;
    } */


    public int compareTo(PlayerScore otherScore){
        if(amountClicks == otherScore.getAantalClicks() && time > otherScore.getTijd()){
            return 1;
            //verplaats 1e naar 2e (doe dit in Model!)

        }else if(amountClicks > otherScore.getAantalClicks()){
            return 1;
            //verplaats 1e naar 2e (doe dit in Model!)

        }else if(amountClicks == otherScore.getAantalClicks() && time == otherScore.getTijd()) {
            return 0;
        }else {
            return -1;
        }
        //verglijk volgende 2 (doe dit in Model!)
    }


    public String getNaamSpeler(){
        return namePlayer;
    }

    public int getAantalClicks(){
        return amountClicks;
    }

    public int getTijd(){
        return time;
    }

    public String getDatum(){
        return datum;
    }

    //public String getScore(){return score;}
}
