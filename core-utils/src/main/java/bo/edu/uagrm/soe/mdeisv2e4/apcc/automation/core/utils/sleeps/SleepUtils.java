package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.sleeps;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {
    private SleepUtils() {
    }

    /**
     * Waits for seconds.
     *
     * @param seconds to wait.
     */
    public static void waitFor(final long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Waits for milliseconds.
     *
     * @param milliseconds to wait.
     */
    public static void waitForMillisecond(final long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
