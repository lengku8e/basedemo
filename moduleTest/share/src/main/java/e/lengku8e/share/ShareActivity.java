package e.lengku8e.share;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import e.lengku8e.componentbase.ServiceFactory;

public class ShareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        share();

    }

    private void share() {
        if (ServiceFactory.getInstance().getAccountService().isLogin()) {
            Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, "分享失败", Toast.LENGTH_SHORT);
        }
    }
}
