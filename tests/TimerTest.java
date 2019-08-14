import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @Test
    public void start_CallItWith1Hour_startTimeSetTo1HourTimeObject() {
        TestableTimer testTimer = new TestableTimer();
        testTimer.fakeTime = new FakeTime(3600);

        testTimer.start();
        long result = testTimer.getStartTime().getTimeInSeconds();

        assertEquals(3600, result);
    }

    @Test
    public void stop_CallItWith1HourStartTimeAnd2HourTimeObject_deltaTimeSetTo1Hour() {
        TestableTimer testTimer = new TestableTimer();
        testTimer.setStartTime(new FakeTime(3600));
        testTimer.fakeTime = new FakeTime(7200);

        testTimer.stop();
        long result = testTimer.getDeltaTime().getTimeInSeconds();

        assertEquals(3600, result);
    }

    @Test
    public void showDeltaTime_ValidTimespan_CallsGuiFunctionShowTime() {
        Timer testTimer = new Timer();
        FakeGui mockGui = new FakeGui();

        testTimer.setDeltaTime(new FakeTime(3600 * 4));
        testTimer.setGui(mockGui);
        testTimer.showDeltaTime();

        assertEquals(3600 * 4, mockGui.showTimeGotCalledWithThisTime);
    }

    @Test
    public void storeDeltaTime_ValidTimespan_CallsDatabaseFuntionStoreTime() {
        Timer testTimer = new Timer();
        FakeDB mockDB = new FakeDB();

        testTimer.setDeltaTime(new FakeTime(3600 * 3));
        testTimer.setDB(mockDB);
        testTimer.storeDeltaTime();

        assertEquals(3600 * 3, mockDB.saveTimeEntryGotCalledWithThisTime);
    }

}

class FakeTime implements ITime {



    long timeInSeconds;
    long unixTime;

    FakeTime(long seconds) {
        setTimeInSeconds(seconds);
    }

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(long timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public ITime minus(ITime other) {
        Time resultTime = new Time();
        resultTime.setTimeInSeconds(timeInSeconds - other.getTimeInSeconds());
        return resultTime;
    }
}

class FakeGui implements IGui {
    public long showTimeGotCalledWithThisTime;

    public void showTime(ITime time) {
        showTimeGotCalledWithThisTime = time.getTimeInSeconds();
    }
}

class FakeDB implements IDB {
    public long saveTimeEntryGotCalledWithThisTime;

    public void storeTimeEntry(ITime time) {
        saveTimeEntryGotCalledWithThisTime = time.getTimeInSeconds();
    }
}

class TestableTimer extends Timer {

    ITime fakeTime;

    @Override
    public ITime retrieveCurrentTime() {
        return fakeTime;
    }
}