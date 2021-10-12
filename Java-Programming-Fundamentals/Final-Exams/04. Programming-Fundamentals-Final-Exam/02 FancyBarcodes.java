import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Pattern patternValid = Pattern.compile("@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+");
        Pattern patternDigit = Pattern.compile("[\\d]");
        for (int i = 0; i < lines; i++) {
            String barcode = scanner.nextLine();
            Matcher matcherValid = patternValid.matcher(barcode);
            if (matcherValid.find()) {
                StringBuilder productGroup = new StringBuilder();
                String validBarcode = matcherValid.group();
                Matcher matcherDigit = patternDigit.matcher(validBarcode);
                while (matcherDigit.find()) {
                    productGroup.append(matcherDigit.group());
                }
                if (productGroup.length() > 0) {
                    System.out.printf("Product group: %s%n", productGroup);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}