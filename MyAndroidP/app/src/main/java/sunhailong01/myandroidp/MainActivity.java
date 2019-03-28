package sunhailong01.myandroidp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import dalvik.system.DexClassLoader;
import pl.droidsonroids.gif.GifImageButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GifImageButton gifImageButton = new GifImageButton(getBaseContext());
        File sdcardDir =Environment.getExternalStorageDirectory();
        path=sdcardDir.getPath()+"/dexOpt";
        requestPermissions(new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1);
//        String apkPath = Environment.getExternalStorageDirectory() + "/app-debug.apk";
        String apkPath = getFileStreamPath("app-debug.apk").getAbsolutePath();
        loadApk(apkPath);
        getMyClass("android.app.Activity");
        getInstanceFromClass("sunhailong01.myandroidp.Person");
        getInstanceFromConstructror("sunhailong01.myandroidp.Person");

        getMethodFromInstance("sunhailong01.myandroidp.Person");
        getFieldFromInstance("sunhailong01.myandroidp.Person");

    }

    private void getFieldFromInstance(String s) {
        try {
            Class c1 = Class.forName(s);
            Constructor cons = null;
            //1. 拿到参数为String 和 int的构造函数
            cons = c1.getConstructor(String.class, int.class);
            //2.通过指定的构造器对象进行对象的初始化。
            Object obj = cons.newInstance("shl", 123213123);

            Field f = c1.getDeclaredField("name");    //返回name属性
            f.setAccessible(true);    //私有属性可见

            String name = (String)f.get(obj);   //返回obj对象的name属性的值
            Log.d("myClass","返回obj对象的name属性的值" + name);

            f.set(obj, "gaibiandeshl");      //设置obj对象的name属性为n值；
            String name1 = (String)f.get(obj);   //返回obj对象的name属性的值
            Log.d("myClass","返回obj对象gaibiandeshl的name属性的值" + name1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private void getMethodFromInstance(String s) {

        try {
            Class c = Class.forName(s);
            // 调用getmethod方法，传入方法名，以及参数对象类型
            Method method = c.getDeclaredMethod("paramShow", String.class, int.class);
            // 调用invoke传入对象，调用非静态的方法paramShow
            method.setAccessible(true);
            Object obj = method.invoke(c.newInstance(),"shl", 888);
            Log.d("myClass", "objreturn" + obj.toString());

            Method staticMethod = c.getMethod("staticShow");
            Object staticReturnObj = staticMethod.invoke(null);

            Log.d("myClass", "staticReturnObj" + staticReturnObj.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private void loadApk(String apkPath) {
        Log.v("loadDexClasses", "Dex preparing");

        final DexClassLoader classLoader = new DexClassLoader(apkPath, path, null, this.getClassLoader());
        Log.v("loadDexClasses", "Search for class");
        try {
            Class<?> classNeedLoad =  (Class<?>) classLoader.loadClass("e.sunhailong01.myapplication.ClassNeedLoad");
            Object instance = classNeedLoad.newInstance();
            Method method = classNeedLoad.getMethod("method");
            method.invoke(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,
                                            int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //创建文件夹
//                     File dex = this.getExternalFilesDir("dexaOpt");

                    File path1 = new File(path);
                    if (!path1.exists()) {
                        //若不存在，创建目录
                        path1.mkdirs();
                    }
                    break;
                }
        }
    }
    String path;

    /**
     * 通过反射获得某个类中的信息
     * @param className 类的路径，如果不在同一包里里需要带上包名
     */
    public void getMyClass(String className) {
        try {
            Class<?> c = Class.forName(className);
            Log.d("myClass", "cname" + c.getName());
            Class<?> cSuper = c.getSuperclass();
            cSuper.getName();
            Log.d("myClass", "cSuperName" + cSuper.getName());
            c.getConstructor();

            Constructor cons[] = c.getConstructors();         //获得公开的构造方法
            Log.d("myClass", "获得公开构造函数信息====================");
            for (int i = 0; i < cons.length; i++) {
                String modifier = Modifier.toString(cons[i].getModifiers());   //获得访问权限
                Log.d("myClass", "获得访问权限" + modifier);
                String name = cons[i].getName();            //获得构造方法名称
                Log.d("myClass", "获得构造方法名称" + name);
                Class<?> params[] = cons[i].getParameterTypes();// 获得参数类型对象
                if(params.length > 0) {
                    for (int j = 0; j < params.length; j++) {
                        Log.d("myClass", "获得参数类型对象" + params[j].getName());
                    }
                } else {
                    Log.d("myClass", "只有无参构造函数");
                }

            }
            Log.d("myClass", "==========================");
            Constructor dcons[] = c.getDeclaredConstructors();        //获得全部构造方法
            Log.d("myClass", "获得全部构造函数的信息,不区分public或private=================");
            for (int i = 0; i < dcons.length; i++) {
                String modifier = Modifier.toString(dcons[i].getModifiers());   //获得访问权限
                Log.d("myClass", "获得访问权限" + modifier);
                String name = dcons[i].getName();            //获得构造方法名称
                Log.d("myClass", "获得构造方法名称" + name);
                Class<?> params[] = dcons[i].getParameterTypes(); // 获得参数类型对象
                if(params.length > 0) {
                    for (int j = 0; j < params.length; j++) {
                        Log.d("myClass", "获得参数类型对象" + params[j].getName());
                    }
                } else {
                    Log.d("myClass", "只有无参构造函数");
                }
            }
            Log.d("myClass", "==========================");
            Log.d("myClass", "获得本类全部包括继承方法（public的）==========================");
            for (Method ms : c.getMethods()) {

                String name = ms.getName();
                Log.d("myClass", "方法名" + name);
                Class<?> rt = ms.getReturnType();
                Log.d("myClass", "返回值" + rt.getName());
                Class<?>params[] = ms.getParameterTypes();
                for (Class<?> a : params) {
                    Log.d("myClass", "params" + a.getName());
                }

                String modifier = Modifier.toString(ms.getModifiers());
                Log.d("myClass", "访问权限" + modifier);
                Class<?>ex[] = ms.getExceptionTypes();        //获得异常
                for(Class<?> ex1 : ex) {
                    String exceptionName = ex1.getName(); //获得异常名称
                    Log.d("myClass", "exceptionName" + exceptionName);
                }

            }
            Log.d("myClass", "==============================");
            Log.d("myClass", "获得本类不包括继承的方法（本类所有，不区分public 或 private）==========================");
            for (Method ms : c.getDeclaredMethods()) {
                String name = ms.getName();
                Log.d("myClass", "方法名" + name);
                Class<?> rt = ms.getReturnType();
                Log.d("myClass", "返回值" + rt.getName());
                Class<?>params[] = ms.getParameterTypes();
                for (Class<?> a : params) {
                    Log.d("myClass", "params" + a.getName());
                }

                String modifier = Modifier.toString(ms.getModifiers());
                Log.d("myClass", "访问权限" + modifier);
                Class<?>ex[] = ms.getExceptionTypes();        //获得异常
                for(Class<?> ex1 : ex) {
                    String exceptionName = ex1.getName(); //获得异常名称
                    Log.d("myClass", "exceptionName" + exceptionName);
                }

            }

            Field fs[] = c.getFields();       //获得公共属性，包括继承属性
            Log.d("myClass", "获得公共属性，包括继承属性==========================");
            for (int i = 0; i < fs.length; i++) {
                Class<?> type = fs[i].getType();
                Log.d("myClass", "获得属性对象" + type);
                String name = fs[i].getName();        //获得属性的名称
                Log.d("myClass", "获得属性的名称" + name);
                String modifier = Modifier.toString(fs[i].getModifiers());
                Log.d("myClass", "获得属性权限" + modifier);
            }
            Log.d("myClass", "================================");
            Log.d("myClass", "获得本类不包括继承属性=============================");
            Field dfs[] = c.getDeclaredFields();    // 获得本类全部属性
            for (int i = 0; i < dfs.length; i++) {
                Class<?> type = fs[i].getType();        //获得属性的类型对象
                Log.d("myClass", "获得属性对象" + type);
                String name = fs[i].getName();        //获得属性的名称
                Log.d("myClass", "获得属性的名称" + name);
                String modifier = Modifier.toString(fs[i].getModifiers());
                Log.d("myClass", "获得属性权限" + modifier);
            }
            Log.d("myClass", "===================================");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }



    private void getInstanceFromClass(String classPath) {
        try {
            Class<?> myClass = Class.forName(classPath);
            // 这里执行class的newInstance会默认调用该类的无参构造函数，假如该类没有定义无参的构造函数
            // 则会抛InstantiationException异常
            Object obj = myClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void getInstanceFromConstructror(String classPath) {
        try {
            Class<?> myClass = Class.forName(classPath);

            Constructor cons = null;
            try {
                //1. 拿到参数为String 和 int的构造函数
                cons = myClass.getConstructor(String.class, int.class);
                //2.通过指定的构造器对象进行对象的初始化。
                Object obj = cons.newInstance("shl", 123213123);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }








}
