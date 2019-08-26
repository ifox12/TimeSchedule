class Timer {

    private Time baseTime;
    private Time nextTime;

    void start() {
        setBaseTime(new Time());
    }

    void stop() {
        setNextTime(new Time());
    }

    Time timerResult() {
        return getNextTime().subtract(getBaseTime());
    }

    private Time getBaseTime() {
        return baseTime;
    }

    private void setBaseTime(Time baseTime) {
        this.baseTime = baseTime;
    }

    private Time getNextTime() {
        return nextTime;
    }

    private void setNextTime(Time nextTime) {
        this.nextTime = nextTime;
    }

    void printTimerResult() {
        Time resultingTime = timerResult();
        System.out.println(resultingTime.getHours() + ":" + resultingTime.getMinutes() + ":" + resultingTime.getSeconds());
    }

    void passTime(int seconds) {
        nextTime = new Time().add(new Time(seconds));
    }
}