package sunhailong01.myandroidp;

import android.app.Application;
import android.os.Process;
import android.util.Log;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String processName = TestUtil.getAppNameByPID(getApplicationContext(), Process.myPid());
        Log.d("MyApplication", "processName" + processName + "processid" + Process.myPid());


    }


}
