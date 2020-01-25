import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {

        SplitClassLoader loader = new SplitClassLoader();
        Class<?> c = loader.findClass("SomeClass");
        Object ob = c.newInstance();
        Method md = c.getMethod("wow");
        md.invoke(ob);
    }
}