import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @Test
    void printTimerResult_Driver_ShowsTimeDiff() throws InterruptedException {
        Timer testTimer = new Timer();
        testTimer.start();
        Thread.sleep(3000);
        testTimer.stop();
        testTimer.printTimerResult();
    }

    @Test
    void timerResult_Run_NotZero() throws InterruptedException {
        Timer testTimer = new Timer();
        testTimer.start();
        Thread.sleep(2000);
        testTimer.stop();
        assertTrue(testTimer.timerResult().isNotZero());
    }

}
