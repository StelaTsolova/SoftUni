import java.util.Scanner;

public class MaxSequenceOfEqualElements_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int lenght = 1;
        String digit = "";
        int bestLenght = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].equals(array[i + 1])){
                lenght ++;
            } else {
                lenght = 1;
            }
            if (lenght > bestLenght){
                bestLenght = lenght;
                digit = array[i];
            }
        }
        for (int i = 0; i < bestLenght; i++) {
            System.out.print(digit + " ");
        }
    }
}