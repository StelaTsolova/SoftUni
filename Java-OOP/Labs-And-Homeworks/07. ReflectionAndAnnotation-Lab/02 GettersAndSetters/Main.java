package GettersAndSetters_2;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> reflection = Class.forName("GettersAndSetters_2.Reflection");

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).filter(m -> m.getName().contains("get") || m.getName().contains("set"))
                .sorted(Comparator.comparing(Method::getName)).forEach(m -> System.out.println(getFormattedMethod(m)));
    }

    private static String getFormattedMethod(Method method) {
        return method.getName().contains("get")
                ? String.format("%s will return class %s", method.getName(), method.getReturnType().getName())
                : String.format("%s and will set field of class %s", method.getName(), method.getParameterTypes()[0].getName());
    }
}
