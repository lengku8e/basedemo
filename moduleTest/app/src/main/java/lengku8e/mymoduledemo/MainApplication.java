package lengku8e.mymoduledemo;

import android.app.Application;

import e.lengku8e.base.AppConfig;
import e.lengku8e.base.BaseApp;

public class MainApplication extends BaseApp {

    @Override
    public void initModuleApp(Application application) {
        for (int i = 0; i < AppConfig.moduleApps.length; i++) {
            try {
                Class moduleAppClass = Class.forName(AppConfig.moduleApps[i]);
                BaseApp baseApp = (BaseApp) moduleAppClass.newInstance();
                baseApp.initModuleApp(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleData(Application application) {
        for (int i = 0; i < AppConfig.moduleApps.length; i++) {
            try {
                Class moduleAppClass = Class.forName(AppConfig.moduleApps[i]);
                BaseApp baseApp = (BaseApp) moduleAppClass.newInstance();
                baseApp.initModuleData(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
