import java.util.*;

public class HeroesOfCodeAndLogicVII_3_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> heroes = new TreeMap<>();
        int numberHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberHeroes; i++) {
            String[] heroInformation = scanner.nextLine().split("\\s+");
            String name = heroInformation[0];
            int HP = Integer.parseInt(heroInformation[1]);
            int MP = Integer.parseInt(heroInformation[2]);
            heroes.put(name, new ArrayList<>(Arrays.asList(HP, MP)));
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" - ");
            String heroName = command[1];
            switch (command[0]){
                case "CastSpell":
                    int MPNeeded = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    if (heroes.get(heroName).get(1) >= MPNeeded){
                        heroes.get(heroName).set(1, heroes.get(heroName).get(1) - MPNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command[2]);
                    String attacker = command[3];
                    heroes.get(heroName).set(0, heroes.get(heroName).get(0) - damage);
                    if (heroes.get(heroName).get(0) > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroes.get(heroName).get(0));
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(command[2]);
                    int newMP = heroes.get(heroName).get(1) + amount;
                    if (newMP >= 200){
                        System.out.printf("%s recharged for %d MP!%n", heroName, 200 - heroes.get(heroName).get(1));
                        heroes.get(heroName).set(1, 200);
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", heroName, newMP - heroes.get(heroName).get(1));
                        heroes.get(heroName).set(1, newMP);
                    }
                    break;
                case "Heal":
                    int amountH = Integer.parseInt(command[2]);
                    int newHP = heroes.get(heroName).get(0) + amountH;
                    if (newHP >= 100){
                        System.out.printf("%s healed for %d HP!%n", heroName, 100 - heroes.get(heroName).get(0));
                        heroes.get(heroName).set(0, 100);
                    } else {
                        System.out.printf("%s healed for %d HP!%n", heroName, newHP - heroes.get(heroName).get(0));
                        heroes.get(heroName).set(0, newHP);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.entrySet().stream().sorted((h1, h2) -> h2.getValue().get(0).compareTo(h1.getValue().get(0)))
                .forEach(e -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
    }
}