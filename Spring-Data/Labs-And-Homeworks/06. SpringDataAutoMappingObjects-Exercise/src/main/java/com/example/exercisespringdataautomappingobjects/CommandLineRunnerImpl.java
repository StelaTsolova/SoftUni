package com.example.exercisespringdataautomappingobjects;

import com.example.exercisespringdataautomappingobjects.models.dtios.*;
import com.example.exercisespringdataautomappingobjects.services.GameService;
import com.example.exercisespringdataautomappingobjects.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private Scanner scanner;
    private UserService userService;
    private GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter your command:");
            String[] command = scanner.nextLine().split("\\|");
            Set<String> resultInfo;
            switch (command[0]) {
                // 2. Implement User Registration, Login and Logout
                case "RegisterUser":
                    UserRegisterDto userRegisterDto = new UserRegisterDto(command[1], command[2],
                            command[3], command[4]);
                    resultInfo = this.userService.registerUser(userRegisterDto);

                    resultInfo.forEach(System.out::println);
                    break;
                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(command[1], command[2]);

                    System.out.println(this.userService.loginUser(userLoginDto));
                    break;
                case "Logout":
                    System.out.println(this.userService.logout());
                    break;

                // 3. Implement Managing Games
                case "AddGame":
                    GameAddDto addGameDto = new GameAddDto(command[1], new BigDecimal(command[2]),
                            Double.parseDouble(command[3]), command[4], command[5], command[6],
                            LocalDate.parse(command[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));

                    resultInfo = this.gameService.addGame(addGameDto);

                    resultInfo.forEach(System.out::println);
                    break;
                case "EditGame":
                    resultInfo = this.gameService.editGame(command[1],
                            new GameEditDto(new BigDecimal(command[2].split("=")[1]),
                                    Double.parseDouble(command[3].split("=")[1])));

                    resultInfo.forEach(System.out::println);
                    break;
                case "DeleteGame":
                    System.out.println(this.gameService.deleteGameById(command[1]));
                    break;

                // 4. Implement View Games
                case "AllGames":
                    this.gameService.getAllGameTitlesAndPrices()
                            .forEach(i -> System.out.println(i.getTitle() + " " + i.getPrice()));
                    break;
                case "DetailGame":
                    GameDetailsDto game = this.gameService.getDetailsByTiTle(command[1]);

                    System.out.printf("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                            game.getTitle(), game.getPrice(), game.getDescription(),
                            game.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                case "OwnedGames":
                    this.userService.getLoggedInUserGameTitles().forEach(System.out::println);
                    break;

                // 5. Implement Shopping Cart
                case "AddItem":
                    System.out.println(this.userService.addItemInCart(command[1]));
                    break;
                case "RemoveItem":
                    System.out.println(this.userService.removeItemFromCart(command[1]));
                    break;
                case "BuyItem":
                    Set<String> addedGameTitles = this.userService.buyItem();
                    if (!addedGameTitles.isEmpty()) {
                        System.out.println("Successfully bought games:");
                        addedGameTitles.forEach(title -> System.out.println(" -" + title));
                    }
                    break;
            }
        }
    }
}
