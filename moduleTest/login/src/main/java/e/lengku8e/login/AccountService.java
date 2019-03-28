package e.lengku8e.login;

import e.lengku8e.componentbase.service.IAccountService;

public class AccountService implements IAccountService {

    @Override
    public boolean isLogin() {
        return true;
    }

    @Override
    public String getAccountId() {
        return "123456";
    }
}
