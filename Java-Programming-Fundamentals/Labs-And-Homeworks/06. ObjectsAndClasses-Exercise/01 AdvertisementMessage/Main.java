package AdvertisementMessage_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Message massage = new Message();

        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfMessages; i++) {
            int numberPhrase = random.nextInt(6);
            int numberEvent = random.nextInt(6);
            int numberAuthor = random.nextInt(8);
            int numberCity = random.nextInt(5);
            String output = massage.generatesMessage(numberPhrase, numberEvent, numberAuthor, numberCity);
            System.out.println(output);
        }
    }
}
