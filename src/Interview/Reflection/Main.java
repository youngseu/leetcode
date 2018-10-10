package Interview.Reflection;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        //1.获取student对象的字节码
        Class clazz = Class.forName("Interview.Reflection.Student");

        //2.获取main方法
        Method methodmain = clazz.getMethod("main", String[].class);

        //3.调用main方法
        methodmain.invoke(null, "a");


    }
}
