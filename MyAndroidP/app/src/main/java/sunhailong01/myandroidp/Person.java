package sunhailong01.myandroidp;

import android.util.Log;

public class Person {

    private String name;
    private int age;
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        Log.d("myClass", "person have param constructor run");
    }

    public Person() {
        super();
        Log.d("myClass", "person no param constructor run");

    }

    public void show(){
        Log.d("myClass", "person show run");
    }

    public static int staticShow(){
        Log.d("myClass", "person static show run");
        return 123123123;
    }

    private String paramShow(String name, int age){
        Log.d("myClass", "show:"+name+"---"+age);
        return "person非静态方法";
    }

}
