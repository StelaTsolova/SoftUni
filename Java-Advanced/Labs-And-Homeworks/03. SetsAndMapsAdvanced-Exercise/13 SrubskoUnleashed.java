import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> statistics = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(?<singer>([A-Za-z]+( [A-Za-z]+){0,2})) [@](?<venue>([A-Za-z]+( [A-Za-z]+){0,2})) (?<ticketsPrice>[0-9]{1,3}) (?<ticketsCount>[0-9]{1,6})");
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String venue = matcher.group("venue");
                String singer = matcher.group("singer");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
                long money = ticketsPrice * (long) ticketsCount;
                statistics.putIfAbsent(venue, new LinkedHashMap<>());
                statistics.get(venue).putIfAbsent(singer, (long) 0);
                statistics.get(venue).put(singer, statistics.get(venue).get(singer) + money);
            }
            input = scanner.nextLine();
        }
        statistics.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).forEach(s -> {
                System.out.println("#  " + s.getKey() + " -> " + s.getValue());
            });
        });
    }
}