package HarvestingFields_1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Field[] allFields = RichSoilLand.class.getDeclaredFields();
        Map<String, List<Field>> mapFields = getMapWithKeys();
        fillMapWhitFields(mapFields, allFields);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {
            printFields(mapFields, input);

            input = scanner.nextLine();
        }
    }

    private static Map<String, List<Field>> getMapWithKeys() {
        Map<String, List<Field>> mapFields = new LinkedHashMap<>();

        mapFields.put("public", new ArrayList<>());
        mapFields.put("private", new ArrayList<>());
        mapFields.put("protected", new ArrayList<>());
        mapFields.put("all", new ArrayList<>());

        return mapFields;
    }

    private static void fillMapWhitFields(Map<String, List<Field>> mapFields, Field[] allFields) {
        for (Field field : allFields) {
            if (Modifier.isPublic(field.getModifiers())) {
                mapFields.get("public").add(field);
            } else if (Modifier.isPrivate(field.getModifiers())) {
                mapFields.get("private").add(field);
            } else if (Modifier.isProtected(field.getModifiers())) {
                mapFields.get("protected").add(field);
            }
            mapFields.get("all").add(field);
        }
       // mapFields.get("all").addAll(Arrays.stream(allFields).toList());
    }

    private static void printFields(Map<String, List<Field>> mapFields, String type) {
        mapFields.get(type).forEach(f ->
                System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
    }
}
