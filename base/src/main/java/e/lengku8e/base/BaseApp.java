package e.lengku8e.base;

import android.app.Application;

public abstract class BaseApp extends Application {

    public abstract void initModuleApp(Application application);

    public abstract void initModuleData(Application application);


}
