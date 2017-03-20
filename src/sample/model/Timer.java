package sample.model;

public class Timer {
    private int hours, minutes, seconds, milliSec;

    public void tick() {
        this.milliSec++;

        if(this.milliSec ==1000){
            this.milliSec =0;
            this.seconds++;
        }
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
        }
        if (this.minutes == 60) {
            this.minutes = 0;
            this.hours++;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliSec(){
        return milliSec;
    }

    public String getMilliSecPlayed(){
        int min = this.hours*60 + this.minutes;
        int sec = min*60 + this.seconds;
        int milliSec = sec*1000 + this.milliSec;
        return Integer.toString(milliSec);
    }



}
