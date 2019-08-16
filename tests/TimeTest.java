import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void add_AddSeconds_PlainAdditionResult() {

        Time testTime = new Time(1);

        Time result = testTime.add(new Time(2));

        assertEquals(3, result.getSeconds());
    }

    @Test
    void add_AddSecondsCrossingOver60_ConvertFull60SecondsToMinutes() {

        Time testTime = new Time(59);

        Time result = testTime.add(new Time(2));

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    void add_AddMinutesCrossingOver60_ConvertFull60MinuteToHours() {

        Time testTime = new Time(0, 59);

        Time result = testTime.add(new Time(0, 2));

        assertEquals(1, result.getHours());
        assertEquals(1, result.getMinutes());
    }

    @Test
    void add_AddMinutesAndSecondsToMinutesAndSecondsNoCrossingOver_CorrectSeperateAdditions() {

        Time testTime = new Time(1, 1);

        Time result = testTime.add(new Time(2, 2));

        assertEquals(3, result.getMinutes());
        assertEquals(3, result.getSeconds());
    }

    @Test
    void add_AddSecondsToMinutes_KeepMinutesAndJustAddSeconds() {

        Time testTime = new Time(0, 1);

        Time result = testTime.add(new Time(1, 0));

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    void add_AddSecondsToMinutesCrossingOverFullMinute_CorrectAddingMinutes() {

        Time testTime = new Time(59, 1);

        Time result = testTime.add(new Time(2, 0));

        assertEquals(1, result.getSeconds());
        assertEquals(2, result.getMinutes());
    }

    @Test
    void add_AddMinutesToSecondsWithoutCrossingOver_CorrectAddition() {
        Time testTime = new Time(1);

        Time result = testTime.add(new Time(0, 1));

        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    void add_AddHoursToZero_TimeEqualsAddend() {
        Time testTime = new Time();

        Time result = testTime.add(new Time(0,0, 1));

        assertEquals(0, result.getSeconds());
        assertEquals(0, result.getMinutes());
        assertEquals(1, result.getHours());
    }

    @Test
    void add_SecondsMinutesHoursToSecondsMinutesHoursWithoutCrossingOver_CorrectAddition() {
        Time testTime = new Time(3, 2, 1);

        Time result = testTime.add(new Time(1, 2, 3));

        assertEquals(4, result.getHours());
        assertEquals(4, result.getMinutes());
        assertEquals(4, result.getSeconds());
    }

    @Test
    void add_SecondsMinutesHoursToSecondsMinutesHoursWithCrossingOver_CorrectAddition() {
        Time testTime = new Time(59, 58, 1);

        Time result = testTime.add(new Time(2, 3, 4));

        assertEquals(6, result.getHours());
        assertEquals(2, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    void subtract_SecondsMinutesHoursFromSecondsMinutesHours_CorrectSubtraction() {
        Time testTime = new Time(2, 2, 2);

        Time result = testTime.subtract(new Time(1, 1,1));

        assertEquals(1, result.getHours());
        assertEquals(1, result.getMinutes());
        assertEquals(1, result.getSeconds());
    }

    @Test
    void subtract_MoreSecondsFromSeconds_NegativeSeconds() {
        Time testTime = new Time(1);

        Time result = testTime.subtract(new Time(2));

        assertEquals(-1, result.getSeconds());
    }

    @Test
    void subtract_MinutesFromSeconds_ExpectedResult() {
        Time testTime = new Time(1);

        Time result = testTime.subtract(new Time(0, 2));

        assertEquals(-1, result.getMinutes());
        assertEquals(-59, result.getSeconds());

    }
}
