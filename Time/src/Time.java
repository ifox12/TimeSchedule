class Time {
    private final int SECONDS_PER_HOUR = 3600;
    private final int MINUTES_PER_HOUR = 60;
    private final int SECONDS_PER_MINUTE = 60;

    private int internalSeconds = 0;

    public Time(int seconds) {
        setSeconds(seconds);
    }

    public Time(int seconds, int minutes) {
        setSeconds(seconds);
        setMinutes(minutes);
    }

    public Time() {
        setSeconds(0);
    }


    public Time add(int seconds) {
        return add(seconds, 0, 0);

    }

    public void setSeconds(int seconds) {
        this.internalSeconds += seconds;
    }

    public void setMinutes(int minutes) {
        this.internalSeconds += convertMinutesToInternal(minutes);
    }

    public Time add(int seconds, int minutes) {
        return add(seconds, minutes, 0);
    }

    private int convertMinutesToInternal(int minutes) {
        return minutes * SECONDS_PER_MINUTE;
    }

    public int getSeconds() {
        return internalSeconds % SECONDS_PER_MINUTE;
    }

    public int getMinutes() {
        return internalSeconds / SECONDS_PER_MINUTE % MINUTES_PER_HOUR;
    }

    public int getHours() {
        return internalSeconds / SECONDS_PER_MINUTE / MINUTES_PER_HOUR;
    }

    public Time add(int seconds, int minutes, int hours) {
        return new Time(this.internalSeconds + seconds + convertMinutesToInternal(minutes) + convertHoursToInternal(hours));
    }

    private int convertHoursToInternal(int hours) {
        return hours * SECONDS_PER_HOUR;
    }
}
