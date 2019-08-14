import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

    @Test
    public void add_AddSeconds_PlainAdditionResult() {

        Time testTime = new Time(1);

        Time result = testTime.add(2);

        assertEquals(3, result.getSeconds());
    }

    @Test
    public void add_AddSecondsCrossingOver60_ConvertFull60SecondsToMinutes() {

        Time testTime = new Time(59);

        Time result = testTime.add(2);

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    public void add_AddMinutesCrossingOver60_ConvertFull60MinuteToHours() {

        Time testTime = new Time(0, 59);

        Time result = testTime.add(0, 2);

        assertEquals(1, result.getHours());
        assertEquals(1, result.getMinutes());
    }

    @Test
    public void add_AddMinutesAndSecondsToMinutesAndSecondsNoCrossingOver_CorrectSeperateAdditions() {

        Time testTime = new Time(1, 1);

        Time result = testTime.add(2, 2);

        assertEquals(3, result.getMinutes());
        assertEquals(3, result.getSeconds());
    }

    @Test
    public void add_AddSecondsToMinutes_KeepMinutesAndJustAddSeconds() {

        Time testTime = new Time(0, 1);

        Time result = testTime.add(1, 0);

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    public void add_AddSecondsToMinutesCrossingOverFullMinute_CorrectAddingMinutes() {

        Time testTime = new Time(59, 1);

        Time result = testTime.add(2, 0);

        assertEquals(1, result.getSeconds());
        assertEquals(2, result.getMinutes());
    }

    @Test
    public void add_AddMinutesToSecondsWithoutCrossingOver_CorrectAddition() {
        Time testTime = new Time(1);

        Time result = testTime.add(0, 1);

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    public void add_AddHoursToZero_TimeEqualsAddend() {
        Time testTime = new Time();

        Time result = testTime.add(0,0, 1);

        assertEquals(0, result.getSeconds());
        assertEquals(0, result.getMinutes());
        assertEquals(1, result.getHours());
    }

    @Test
    public void add_SecondsMinutesHoursToSecondsMinutesHoursWithoutCrossingOver_CorrectAddition() {
        Time testTime = new Time(3, 2, 1);

        Time result = testTime.add(1, 2, 3);

        assertEquals(4, result.getHours());
        assertEquals(4, result.getMinutes());
        assertEquals(4, result.getSeconds());

    }
}
