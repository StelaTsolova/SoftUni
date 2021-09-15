import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("[, ]+")).sorted(String::compareTo).collect(Collectors.toList());
        String regexName = "[^\\d+\\+\\-\\*\\/\\.]";
        Pattern patternName = Pattern.compile(regexName);
        String regexDamage = "([-]?\\d+([\\.]?[0-9]+)?)";
        Pattern patternDamage = Pattern.compile(regexDamage);
        String arithmeticAction = "[*\\/]";
        Pattern patternArithmeticAction = Pattern.compile(arithmeticAction);
        for (int i = 0; i < input.size(); i++) {
                String name = input.get(i);

                Matcher matcherName = patternName.matcher(name);
                int health = getHealth(matcherName);

                Matcher matcherDamage = patternDamage.matcher(name);
                double currentDamage = getCurrentDamage(matcherDamage);

                Matcher matcherArithmeticAction = patternArithmeticAction.matcher(name);
                double damage = getDamage(matcherArithmeticAction, currentDamage);

                System.out.printf("%s - %d health, %.2f damage%n", name, health, damage);
        }
    }

    private static int getHealth(Matcher matcherName) {
        int health = 0;
        while (matcherName.find()) {
            health += matcherName.group().charAt(0);
        }
        return health;
    }

    private static double getCurrentDamage(Matcher matcherDamage) {
        double damage = 0;
        while (matcherDamage.find()) {
            damage += Double.parseDouble(matcherDamage.group());
        }
        return damage;
    }

    private static double getDamage(Matcher matcherArithmeticAction, Double currentDamage) {
        double damage = currentDamage;
        while (matcherArithmeticAction.find()) {
            if (matcherArithmeticAction.group().equals("*")) {
                damage *= 2;
            } else if ((matcherArithmeticAction.group().equals("/"))) {
                damage /= 2;
            }
        }
        return damage;
    }
}