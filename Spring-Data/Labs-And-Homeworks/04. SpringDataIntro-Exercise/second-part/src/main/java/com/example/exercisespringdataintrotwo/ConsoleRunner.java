package com.example.exercisespringdataintrotwo;

import com.example.exercisespringdataintrotwo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.persistUsers();

        Scanner scanner = new Scanner((System.in));

        printUsersByEmailProvider(scanner);
    }

    private void printUsersByEmailProvider(Scanner scanner) {
        String provider = scanner.nextLine();
        Set<String> output = this.userService.getAllUsernamesAndEmailsWithProvider(provider);

        if(output.isEmpty()){
            System.out.println("No users found with email domain " + provider);
        } else {
            output.forEach(System.out::println);
        }
    }
}
