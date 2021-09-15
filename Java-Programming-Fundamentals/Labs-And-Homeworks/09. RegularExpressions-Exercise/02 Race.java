import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_2 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> distance = new LinkedHashMap<>();
        participants.forEach(e -> distance.put(e, 0));
        String input = scanner.nextLine();
        String regexName = "[A-Za-z]";
        String regexDigits = "\\d";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDigits  = Pattern.compile(regexDigits);
         while (!input.equals("end of race")){
             Matcher matcherName = patternName.matcher(input);
             Matcher matcherDigits  = patternDigits.matcher(input);
             String name = getName(matcherName);
             if (distance.containsKey(name)) {
                 int runDistance = getRunDistance(matcherDigits);
                 distance.put(name, distance.get(name) + runDistance);
             }
             input = scanner.nextLine();
         }
         List<String> winners = new ArrayList<>();
         distance.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                 .limit(3).forEach(e -> winners.add(e.getKey()));
        System.out.printf("1st place: %s%n", winners.get(0));
        System.out.printf("2nd place: %s%n", winners.get(1));
        System.out.printf("3rd place: %s", winners.get(2));
    }

    private static String getName(Matcher matcherName) {
        StringBuilder name = new StringBuilder();
        while (matcherName.find()){
            name.append(matcherName.group());
        }
        return name.toString();
    }

    private static int getRunDistance(Matcher matcherDigits) {
        int runDistance = 0;
        while (matcherDigits.find()){
            runDistance += Integer.parseInt(matcherDigits.group());
        }
        return runDistance;
    }
}