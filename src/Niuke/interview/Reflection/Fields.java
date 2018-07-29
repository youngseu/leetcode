package Niuke.interview.Reflection;

import java.lang.reflect.Field;

/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */
public class Fields {

    public static void main(String[] args) throws Exception {
        //1.获得class对象
        Class stu = Class.forName("Niuke.interview.Reflection.Student");

        //2.获取字段
        System.out.println("获取所有公有字段");
        Field[] fieldArray = stu.getFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println();

        System.out.println("获取所有的字段，包括私有、公有、保护");
        fieldArray = stu.getDeclaredFields();
        for (Field f : fieldArray) {
            System.out.println(f);
        }
        System.out.println();

        System.out.println("获取公有字段并调用");
        Field f = stu.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stu.getConstructor().newInstance();
        //字段设置值
        f.set(obj, "yang");
        Student stu1 = (Student) obj;
        System.out.println("验证姓名：" + stu1.name);
        System.out.println();

        System.out.println("获取私有字段并调用");
        f = stu.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "151");
        System.out.println("验证电话：" + stu1);
    }
}
