import java.util.Scanner;

public class PadawanEquipment_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSword = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double countSword = students + (Math.ceil(students * 0.1));
        int freeBelt= students / 6;
        double needMoney = (countSword * priceSword) + (students * priceRobe) + ((students - freeBelt) * priceBelt);
        if (money >= needMoney){
            System.out.println(String.format("The money is enough - it would cost %.2flv.", needMoney));
        } else {
            System.out.println(String.format("George Lucas will need %.2flv more.", needMoney - money));
        }
    }
}