package HighQualityMistakes_3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> reflection = Class.forName("HighQualityMistakes_3.Reflection");

        Field[] fields = reflection.getDeclaredFields();
        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> !Modifier.isPublic(m.getModifiers()) && m.getName().contains("get"))
                .forEach(m -> System.out.println(m.getName() + " have to be public!"));

        Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> !Modifier.isPrivate(m.getModifiers()) && m.getName().contains("set"))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));
    }
}
