package BlackBoxInteger_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> reflection = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = reflection.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Field innerValue = reflection.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        while (!input.equals("END")) {
            String[] info = input.split("_");
            String commandName = info[0];
            int value = Integer.parseInt(info[1]);

            Method method = reflection.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
