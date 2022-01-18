package CodingTracker_5;

import java.util.Arrays;
import java.util.Comparator;

public class Tracker {
    public static void printMethodsByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getAnnotation(Author.class) != null)
                .sorted(Comparator.comparing(m -> m.getAnnotation(Author.class).name()))
                .forEach(m -> System.out.println(m.getAnnotation(Author.class).name() + ": " + m.getName()));
    }
}
