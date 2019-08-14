class Time {
    private final int SECONDS_PER_HOUR = 3600;
    private final int MINUTES_PER_HOUR = 60;
    private final int SECONDS_PER_MINUTE = 60;

    private int internalSeconds = 0;

    Time() {
        setSeconds(0);
    }

    Time(int seconds) {
        setSeconds(seconds);
    }

    Time(int seconds, int minutes) {
        setSeconds(seconds);
        setMinutes(minutes);
    }

    Time add(int seconds) {
        return add(seconds, 0, 0);

    }

    Time add(int seconds, int minutes) {
        return add(seconds, minutes, 0);
    }

    Time add(int seconds, int minutes, int hours) {
        return new Time(this.internalSeconds + seconds + convertMinutesToInternal(minutes) + convertHoursToInternal(hours));
    }

    private void setSeconds(int seconds) {
        this.internalSeconds += seconds;
    }

    private void setMinutes(int minutes) {
        this.internalSeconds += convertMinutesToInternal(minutes);
    }

    int getSeconds() {
        return internalSeconds % SECONDS_PER_MINUTE;
    }

    int getMinutes() {
        return internalSeconds / SECONDS_PER_MINUTE % MINUTES_PER_HOUR;
    }

    int getHours() {
        return internalSeconds / SECONDS_PER_HOUR;
    }

    private int convertMinutesToInternal(int minutes) {
        return minutes * SECONDS_PER_MINUTE;
    }

    private int convertHoursToInternal(int hours) {
        return hours * SECONDS_PER_HOUR;
    }
}
