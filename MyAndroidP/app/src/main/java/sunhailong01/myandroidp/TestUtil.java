package sunhailong01.myandroidp;

import android.app.ActivityManager;
import android.content.Context;

public class TestUtil {
    public static int myId = -1;


    public static String getAppNameByPID(Context context, int pid) {
        ActivityManager manager
                = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return "";
    }
}
