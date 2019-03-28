package e.lengku8e.componentbase.empty_service;

import e.lengku8e.componentbase.service.IAccountService;

public class EmptyAccountService implements IAccountService{
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getAccountId() {
        return null;
    }
}
