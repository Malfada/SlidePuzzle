package sample.model;

public class PlayerScore implements Comparable<PlayerScore> {
    private final String namePlayer;
    private final int clickCount;
    private final int time;
    private final String datum;

    PlayerScore(String namePlayer, int clickCount, int time, String datum) {
        this.namePlayer = namePlayer;
        this.clickCount = clickCount;
        this.time = time;
        this.datum = datum;
    }

    public int compareTo(PlayerScore otherScore){
        if(clickCount == otherScore.getClickCount() && time > otherScore.getTime()){
            return 1;

        }else if(clickCount > otherScore.getClickCount()){
            return 1;

        }else if(clickCount == otherScore.getClickCount() && time == otherScore.getTime()) {
            return 0;
        }else {
            return -1;
        }
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

    String getScoreToString() {
        return namePlayer + "#" + clickCount + "#" + time + "#" + datum;
    }

}
