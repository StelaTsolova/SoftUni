package com.example.exercisespringdataautomappingobjects.services.Impls;

import com.example.exercisespringdataautomappingobjects.models.dtios.UserLoginDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.UserRegisterDto;
import com.example.exercisespringdataautomappingobjects.models.entities.Game;
import com.example.exercisespringdataautomappingobjects.models.entities.User;
import com.example.exercisespringdataautomappingobjects.repositories.GameRepository;
import com.example.exercisespringdataautomappingobjects.repositories.UserRepository;
import com.example.exercisespringdataautomappingobjects.services.UserService;
import com.example.exercisespringdataautomappingobjects.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private User loggedUser;
    private GameRepository gameRepository;

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil,
                           ModelMapper modelMapper, GameRepository gameRepository
                           ) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.loggedUser = null;
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<String> registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            return Set.of("Password not equals confirm password");
        }

        Set<ConstraintViolation<UserRegisterDto>> constraintViolations
                = validationUtil.violations(userRegisterDto);

        if (!constraintViolations.isEmpty()) {
            return constraintViolations.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }

        User user = this.modelMapper.map(userRegisterDto, User.class);

        this.userRepository.save(user);

        return Set.of(userRegisterDto.getFullName() + " was registered");
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        if (!this.validationUtil.isValid(userLoginDto)) {
            return "Incorrect username / password";
        }

        User user = this.userRepository
                .findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (user == null) {
            return "Incorrect username / password";
        }

        this.loggedUser = user;
        return "Successfully logged in " + user.getFullName();
    }

    @Override
    public String logout() {
        if (this.loggedUser == null) {
            return "Cannot log out. No user was logged in.";
        } else {
            String name = this.loggedUser.getFullName();
            this.loggedUser = null;

            return name + " successfully logged out";
        }
    }

    @Override
    public void buyGame(Long userId, Long gameId) {
        Game game = this.gameRepository.findGameById(gameId);

        User user = this.userRepository.findUserById(userId);
        user.getGames().add(game);

        this.userRepository.save(user);
    }

    @Override
    public Set<String> getLoggedInUserGameTitles() {
        return this.loggedUser.getGames().stream().map(Game::getTitle).collect(Collectors.toSet());
    }

    @Override
    public String addItemInCart(String gameTitle) {
        if (this.loggedUser.getGames().stream().anyMatch(g -> g.getTitle().equals(gameTitle))) {
            return this.loggedUser.getFullName() + " already bought " + gameTitle;
        }

        Game game = this.gameRepository.findGameByTitle(gameTitle);
        if (game == null) {
            return gameTitle + " not exist.";
        }

        if (this.loggedUser.getCart().getAddedGames().stream()
                .anyMatch(g -> g.getId() == game.getId())){
            return gameTitle + " already in cart.";
        }

        this.loggedUser.getCart().getAddedGames().add(game);
        this.userRepository.save(this.loggedUser);

        return gameTitle + " added to cart.";
    }

    @Override
    public String removeItemFromCart(String gameTitle) {
        Game game = this.loggedUser.getCart().getAddedGames().stream()
                .filter(g -> g.getTitle().equals(gameTitle))
                .findFirst().orElse(null);

        if (game == null){
            return gameTitle + " not in cart.";
        }

        this.loggedUser.getCart().getAddedGames().remove(game);
        this.userRepository.save(this.loggedUser);

        return gameTitle + " removed from cart.";
    }

    @Override
    public Set<String> buyItem() {
        Set<String> gameTitles = new LinkedHashSet<>();

        this.loggedUser.getCart().getAddedGames().forEach(c ->{
            Game game = this.gameRepository.findGameById(c.getId());
            if (this.loggedUser.getGames().contains(game)){
                return;
            }
           buyGame(this.loggedUser.getId(), game.getId());
            gameTitles.add(game.getTitle());
        });

        this.loggedUser.getCart().getAddedGames().clear();
        this.userRepository.save(this.loggedUser);

        return gameTitles;
    }
}
