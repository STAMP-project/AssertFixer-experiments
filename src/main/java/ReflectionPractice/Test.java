package ReflectionPractice;

import jdk.nashorn.internal.runtime.PropertyHashMap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Properties;

/**
 * Created by jet533 on 9/7/2018.
 */

 public class Test
{
    private int x;
    Test()
    {
        x=10;
    }
//    public void method1()
//    {
//        System.out.print("Hello");
//    }
    protected   void method2(String x)
    {
        System.out.println("Hello " + x);
    }
}
 class RP {

    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IOException {
     /*  Test obj = new Test();
        Class cls = obj.getClass();

        String construct=null;
        Method[] methodd=cls.getDeclaredMethods();
        Type types[];
        System.out.println("Methods ..");
        for(Method m :methodd) {
            System.out.println(m.getName());
            System.out.println(m.getReturnType());
            System.out.println(m.getModifiers());
            switch(m.getModifiers())
            {
                case 1 : construct="public";break;
                case 4 : construct="protected";break;
            }
            construct=construct+" "+m.getReturnType()+" "+m.getName()+" "+"(";
            types=m.getParameterTypes();
            for(Type t : types) {
                System.out.println(t.getTypeName());
                construct=construct+t.getTypeName()+")";
            }
            System.out.print(construct);



        }

        System.out.println("Which method u want to call");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Method m=cls.getDeclaredMethod(br.readLine(),String.class);
        m.invoke(obj,"Nikita");
*/
        FileInputStream file=new FileInputStream("C:\\Users\\JET533\\workspace\\Test\\src\\main\\resources\\Env.properties");
        Properties p=new Properties();
        p.load(file);
        System.out.println("Name : "+ p.getProperty("Name"));

    }


}
