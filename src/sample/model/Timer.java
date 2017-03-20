package sample.model;

public class Timer {
    private static final int START_TICK_DURATION_MILLIS = 1;
    private int hours, minutes, seconds, milisec, tickDurationMillis;

    public Timer() {
        this.tickDurationMillis = START_TICK_DURATION_MILLIS;
    }

    public void tick() {
        this.milisec++;

        if(this.milisec==1000){
            this.milisec=0;
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

    public int getMilisec(){
        return milisec;
    }

    public int getTickDurationMillis() {
        return tickDurationMillis;
    }

    //waarschijnlijk niet nodig
    public void reset() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.milisec = 0;
        //this.tickDurationMillis -= 100;
    }


    //Methodes Timer -> miliseconden zetten
    //Hoe krijg ik de overige milisec??
    public String getMilisecPlayed(){
        int min = hours*60 + minutes;
        int sec = min*60 + seconds;
        int miliss = sec*1000 + milisec;
        String milis = Integer.toString(miliss);
        return milis;
    }



}
