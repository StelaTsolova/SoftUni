package com.example.exercisespringdataintrotwo.services;

import com.example.exercisespringdataintrotwo.models.Album;
import com.example.exercisespringdataintrotwo.models.User;
import com.example.exercisespringdataintrotwo.repositories.AlbumRepository;
import com.example.exercisespringdataintrotwo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AlbumRepository albumRepository;

    public UserServiceImpl(UserRepository userRepository, AlbumRepository albumRepository) {
        this.userRepository = userRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public Set<String> getAllUsernamesAndEmailsWithProvider(String provider) {
        return this.userRepository.getAllByEmailEndsWith(provider).stream()
                .map(user -> String.format("%s %s", user.getUsername(), user.getEmail()))
                .collect(Collectors.toSet());
    }

    @Override
    public void persistUsers() {
        User user = new User();
        user.setUsername("Pesho");
        user.setPassword("pppl!8M");
        user.setAge(26);
        user.setEmail("pesho_peshov@gmail.com");

//        Album album = new Album();
//        this.albumRepository.save(album);

//        user.getAlbums().add(album);
        this.userRepository.save(user);

        User user1 = new User();
        user1.setUsername("Penaa");
        user1.setPassword("1tTkg@90");
        user1.setAge(24);
        user1.setEmail("pena612@gmail.com");

//user1.getAlbums().add(album);
        user1.getFriends().add(user);

        this.userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setUsername("Mona");
//        user2.setPassword("M26kg90.");
//        user2.setEmail("monaaa-aa@gmail.com");
//
//        this.userRepository.save(user2);
//
//        User user3 = new User();
//        user3.setUsername("Lobo");
//        user3.setPassword("M2<kdf90");
//        user3.setEmail("47Lobo@yahoo.co.uk");
//
//        this.userRepository.save(user3);
//
//        User user4 = new User();
//        user4.setUsername("Koko");
//        user4.setPassword("M26kg90#");
//        user4.setEmail("koko_929a@yahoo.co.uk");
//
//        this.userRepository.save(user4);
    }
}
