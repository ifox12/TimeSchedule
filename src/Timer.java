class Timer {

    private Time startTime;

    void start() {
        setStartTime(new Time());
    }

    Time getStartTime() {
        return startTime;
    }

    void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}
