package Niuke.interview.Reflection;


/**
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 */
public class Reflection {
    public static void main(String[] args) {
        //第一种方式获得class对象，需要new出对象后再获得Class对象，“多此一举”
        Student tt = new Student();
        Class tt1 = tt.getClass();
        System.out.println(tt1.getName());

        //第二种方式获得class对象，需要导入类包，依赖性太强
        Class tt2 = Student.class;
        System.out.println(tt2 == tt1);

        //第三种方式获得class对象，字符串传入，最常用，可以写在配置文件中
        try {
            Class tt3 = Class.forName("Niuke.interview.Reflection.Student");
            System.out.println(tt3 == tt2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
