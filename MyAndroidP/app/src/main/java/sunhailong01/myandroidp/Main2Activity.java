package sunhailong01.myandroidp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends Activity {
    private TextView textView;
    private View rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView4);
        rl = findViewById(R.id.rl);
        textView.getX();
        textView.getY();
        textView.getTranslationX();
        textView.getTranslationY();

        Log.d("shl", "tvgetX" + textView.getX());
        Log.d("shl", "tvgetY" + textView.getY());
        Log.d("shl", "tvgetTranslationX" + textView.getTranslationX());
        Log.d("shl", "tvgetTranslationY" + textView.getTranslationY());

        Log.d("shl", "tvgetScrollY" + textView.getScrollY());
        Log.d("shl", "tvgetScrollY" + textView.getScrollY());

        Log.d("shl", "rlgetX" + rl.getX());
        Log.d("shl", "rlgetY" + rl.getY());
        Log.d("shl", "rlgetTranslationX" + rl.getTranslationX());
        Log.d("shl", "rlgetTranslationY" + rl.getTranslationY());

        Log.d("shl", "rl.getScrollX" + rl.getScrollX());
        Log.d("shl", "rl.getScrollY" + rl.getScrollY());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rl.scrollTo(-30, -20);
                Log.d("shl", "scrollTo=======================");
                Log.d("shl", "tvgetX" + textView.getX());
                Log.d("shl", "tvgetY" + textView.getY());
                Log.d("shl", "tvgetTranslationX" + textView.getTranslationX());
                Log.d("shl", "tvgetTranslationY" + textView.getTranslationY());

                Log.d("shl", "tvgetScrollY" + textView.getScrollY());
                Log.d("shl", "tvgetScrollY" + textView.getScrollY());

                Log.d("shl", "rlgetX" + rl.getX());
                Log.d("shl", "rlgetY" + rl.getY());
                Log.d("shl", "rlgetTranslationX" + rl.getTranslationX());
                Log.d("shl", "rlgetTranslationY" + rl.getTranslationY());

                Log.d("shl", "rl.getScrollX" + rl.getScrollX());
                Log.d("shl", "rl.getScrollY" + rl.getScrollY());
                Log.d("shl", "scrollTo=======================");
            }
        }, 1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("shl", "scrollTo=======================");
                rl.scrollTo(-30, -20);
                Log.d("shl", "tvgetX" + textView.getX());
                Log.d("shl", "tvgetY" + textView.getY());
                Log.d("shl", "tvgetTranslationX" + textView.getTranslationX());
                Log.d("shl", "tvgetTranslationY" + textView.getTranslationY());

                Log.d("shl", "tvgetScrollY" + textView.getScrollY());
                Log.d("shl", "tvgetScrollY" + textView.getScrollY());

                Log.d("shl", "rlgetX" + rl.getX());
                Log.d("shl", "rlgetY" + rl.getY());
                Log.d("shl", "rlgetTranslationX" + rl.getTranslationX());
                Log.d("shl", "rlgetTranslationY" + rl.getTranslationY());

                Log.d("shl", "rl.getScrollX" + rl.getScrollX());
                Log.d("shl", "rl.getScrollY" + rl.getScrollY());
                Log.d("shl", "scrollTo=======================");
            }
        }, 2000);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("shl", "scrollBy=======================");
                rl.scrollBy(-30, -20);
                Log.d("shl", "tvgetX" + textView.getX());
                Log.d("shl", "tvgetY" + textView.getY());
                Log.d("shl", "tvgetTranslationX" + textView.getTranslationX());
                Log.d("shl", "tvgetTranslationY" + textView.getTranslationY());

                Log.d("shl", "tvgetScrollY" + textView.getScrollY());
                Log.d("shl", "tvgetScrollY" + textView.getScrollY());

                Log.d("shl", "rlgetX" + rl.getX());
                Log.d("shl", "rlgetY" + rl.getY());
                Log.d("shl", "rlgetTranslationX" + rl.getTranslationX());
                Log.d("shl", "rlgetTranslationY" + rl.getTranslationY());

                Log.d("shl", "rl.getScrollX" + rl.getScrollX());
                Log.d("shl", "rl.getScrollY" + rl.getScrollY());
                Log.d("shl", "scrollBy=======================");
            }
        }, 2500);

    }
}
