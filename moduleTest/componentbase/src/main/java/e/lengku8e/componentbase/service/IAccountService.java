package e.lengku8e.componentbase.service;

public interface IAccountService {
    /**
     * 是否已经登录
     * @return
     */
    boolean isLogin();

    /**
     * 获取登录用户的 AccountId
     * @return
     */
    String getAccountId();
}
