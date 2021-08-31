import java.util.*;

public class CompanyUsers_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companyInformation = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String companyName = input.split(" -> ")[0];
            String currentID = input.split(" -> ")[1];
            companyInformation.putIfAbsent(companyName, new ArrayList<>());
            boolean haveCurrentID = checkingID(companyInformation, companyName, currentID);
            if (!haveCurrentID) {
                companyInformation.get(companyName).add(currentID);
            }
            input = scanner.nextLine();
        }
        companyInformation.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(v -> System.out.println("-- " + v));
        });
    }

    private static boolean checkingID(Map<String, List<String>> companyInformation, String companyName, String currentID) {
        boolean haveID = false;
        for (int i = 0; i < companyInformation.get(companyName).size(); i++) {
            if (companyInformation.get(companyName).get(i).equals(currentID)) {
                haveID = true;
            }
        }
        return haveID;
    }
}