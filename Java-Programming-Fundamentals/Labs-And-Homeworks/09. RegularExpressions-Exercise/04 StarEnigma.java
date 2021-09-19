import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int messages = Integer.parseInt(scanner.nextLine());
        String regexStar = "[SsTtAaRr]";
        Pattern patternStar = Pattern.compile(regexStar);
        String regexMassage = "@(?<planetName>[A-Za-z]+)([^\\@\\,\\-\\!\\:\\>]*)?:(?<population>[0-9]+)([^\\@\\,\\-\\!\\:\\>]*)?!(?<attackType>[AD])!([^\\@\\,\\-\\!\\:\\>]*)?->(?<soldierCount>\\d+)";
        Pattern patternMassage = Pattern.compile(regexMassage);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < messages; i++) {
            String encryptedMessage = scanner.nextLine();
            Matcher matcherStar = patternStar.matcher(encryptedMessage);
            int decryptionKey = 0;
            while (matcherStar.find()) {
                decryptionKey++;
            }
            StringBuilder message = new StringBuilder();
            for (Character letter : encryptedMessage.toCharArray()) {
                message.append((char) (letter - decryptionKey));
            }
            String decryptedMessage = message.toString();
            Matcher matcherMassage = patternMassage.matcher(decryptedMessage);
            while (matcherMassage.find()) {
                String planetName = matcherMassage.group("planetName");
                //  String population = matcherMassage.group("population");
                String attackType = matcherMassage.group("attackType");
                //    int soldierCount = Integer.parseInt(matcherMassage.group("soldierCount"));
                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planetName);
                }
            }

        }
        attackedPlanets.sort(String::compareTo);
        destroyedPlanets.sort(String::compareTo);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.forEach(e -> System.out.println("-> " + e));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.forEach(e -> System.out.println("-> " + e));
    }
}