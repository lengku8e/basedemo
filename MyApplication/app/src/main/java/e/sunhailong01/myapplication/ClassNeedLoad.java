package e.sunhailong01.myapplication;

import android.util.Log;

public class ClassNeedLoad {
    public  int  method(){
        Log.d("ClassToBeLoad", "called method of class " +    ClassNeedLoad.class.getName());
        return 1231313;
    }
}
