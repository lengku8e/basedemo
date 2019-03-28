package e.lengku8e.login;

import android.app.Application;

import e.lengku8e.base.BaseApp;
import e.lengku8e.componentbase.ServiceFactory;

public class LoginApp extends BaseApp {

    @Override
    public void initModuleApp(Application application) {
        ServiceFactory.getInstance()
                .setAccountService(new AccountService());
    }

    @Override
    public void initModuleData(Application application) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }

}
