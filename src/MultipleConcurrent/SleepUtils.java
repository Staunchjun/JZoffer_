package MultipleConcurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/26.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
