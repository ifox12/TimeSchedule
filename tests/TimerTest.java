import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @Test
    void start_CallIt_StartTimeIsZero() {
        Timer testTimer = new Timer();

        testTimer.start();

        assertEquals(0, testTimer.getStartTime().getSeconds());
    }
}
