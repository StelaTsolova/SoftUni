package MilitaryElite_6;

import MilitaryElite_6.Classes.*;
import MilitaryElite_6.Interfaces.*;

import java.util.*;

public class Main {
    private static Map<Integer, Private> privates = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Soldier soldier = createSolder(input);
            if (soldier != null) {
                soldiers.add(soldier);
            }

            input = scanner.nextLine();
        }

        soldiers.forEach(s -> System.out.println(s.toString()));
    }

    private static Soldier createSolder(String input) {
        String[] commands = input.split("\\s+");
        Soldier soldier;
        switch (commands[0]) {
            case "Private":
                int id = Integer.parseInt(commands[1]);
                String firstName = commands[2];
                String lastName = commands[3];
                double salary = Double.parseDouble(commands[4]);
                Private aPrivate = new PrivateImpl(id, firstName, lastName, salary);
                privates.put(id, aPrivate);
            case "LieutenantGeneral":
                soldier = createLieutenantGeneralIml(commands);
                break;
            case "Engineer":
                soldier = createEngineerImpl(commands);
                break;
            case "Commando":
                soldier = createCommando(commands);
                break;
            case "Spy":
                int idS = Integer.parseInt(commands[1]);
                String firstNameS = commands[2];
                String lastNameS = commands[3];
                String codeName = commands[4];
                soldier = new SpyImpl(idS, firstNameS, lastNameS, codeName);
                break;
            default:
                soldier = null;
                break;
        }
        return soldier;
    }

    private static Soldier createLieutenantGeneralIml(String[] commands) {
        int id = Integer.parseInt(commands[1]);
        String firstName = commands[2];
        String lastName = commands[3];
        double salary = Double.parseDouble(commands[4]);
        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

        for (int i = 5; i < commands.length; i++) {
            lieutenantGeneral.addPrivate(privates.get(Integer.parseInt(commands[i])));
        }
        return lieutenantGeneral;
    }

    private static Soldier createEngineerImpl(String[] commands) {
        String corps = commands[5];
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            int id = Integer.parseInt(commands[1]);
            String firstName = commands[2];
            String lastName = commands[3];
            double salary = Double.parseDouble(commands[4]);
            Engineer engineer = new EngineerImpl(id, firstName, lastName, salary,
                    SpecialisedSoldierImpl.Corps.valueOf(corps));

            for (int i = 6; i < commands.length; i += 2) {
                String partName = commands[i];
                int hoursWorked = Integer.parseInt(commands[i + 1]);
                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);
            }
            return engineer;
        }
        return null;
    }

    private static Soldier createCommando(String[] commands) {
        String corps = commands[5];
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            int id = Integer.parseInt(commands[1]);
            String firstName = commands[2];
            String lastName = commands[3];
            double salary = Double.parseDouble(commands[4]);
            Commando commando = new CommandoImpl(id, firstName, lastName, salary,
                   SpecialisedSoldierImpl.Corps.valueOf(corps));

            for (int i = 6; i < commands.length; i += 2) {
                String codeName = commands[i];
                String state = commands[i + 1];

                if (!state.equals("inProgress") && !state.equals("finished")) {
                    continue;
                }
                Mission mission = new MissionImpl(codeName, state.equals("inProgress") ? MissionImpl.Status.inProgress
                        : MissionImpl.Status.finished);
                commando.addMission(mission);
            }
            return commando;
        }
        return null;
    }
}
