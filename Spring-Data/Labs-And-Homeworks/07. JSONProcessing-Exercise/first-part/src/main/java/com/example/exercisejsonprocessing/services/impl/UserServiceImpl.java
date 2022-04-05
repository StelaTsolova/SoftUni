package com.example.exercisejsonprocessing.services.impl;

import com.example.exercisejsonprocessing.models.dtos.*;
import com.example.exercisejsonprocessing.models.entities.Product;
import com.example.exercisejsonprocessing.models.entities.User;
import com.example.exercisejsonprocessing.repositories.UserRepository;
import com.example.exercisejsonprocessing.services.UserService;
import com.example.exercisejsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_NAME = "users.json";

    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtil validationUtil,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() > 0) {
            return;
        }

        String content = Files.readString(Path.of(RESOURCES_FILE_PATH + USER_FILE_NAME));
        UserSeedDto[] userSeedDtos = this.gson.fromJson(content, UserSeedDto[].class);

        List<UserSeedDto> filteredUserSeedDtos = Arrays.stream(userSeedDtos)
                .filter(this.validationUtil::isValid)
                .collect(Collectors.toList());

        List<User> users = (filteredUserSeedDtos).stream()
                .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users);
    }

    @Override
    public User findRandomUser() {
        return this.userRepository.findById(ThreadLocalRandom.current()
                .nextLong(1, this.userRepository.count() + 1)).orElseThrow();
    }

    @Override
    public List<UserSoldDto> findAllUserSoldDtos() {
        return this.userRepository.findAllWithMoreThanOneSoldProductOrderByLastNameThanFirstName()
                .stream().map(user -> this.modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserAndProductsDto findAllUserAndProductsDtos() {

        //  this.modelMapper.addConverter(converter);

        // Converter<Collection, Integer> collectionToSize = c -> c.getSource().size();

//        this.modelMapper.addMappings(new PropertyMap<UserDto, UserSoldProductsDto>() {
//
//            @Override
//            protected void configure() {
//                map().setCount(userRepository
//                        .findUserByFirstNameAndLastName(source.getFirstName(),
//                                source.getLastName()).getSoldProducts().size());
//            }
//        });
//        Converter<Set<Product>, UserSoldProductsDto> converter = (new Converter<Set<Product>, UserSoldProductsDto>() {
//            @Override
//            public UserSoldProductsDto convert(MappingContext<Set<Product>, UserSoldProductsDto> mappingContext) {
//mappingContext.getDestination().setCount(mappingContext.getSource().size());
//
//                return mappingContext.getDestination();
//            }
//        });
//        this.modelMapper
//                .createTypeMap(User.class, UserSoldProductsDto.class)
//                .addMappings(mapper -> mapper.using(collectionToSize)
//                                .map(User::getSoldProducts, UserSoldProductsDto::setCount)
//                );
//        });
     //   Converter<Set, Integer> collectionToSize = c -> c.getSource().size();
//        this.modelMapper.addMappings(new PropertyMap<User, UserSoldProductsDto>() {
//
//            @Override
//            protected void configure() {
//                using(converter).map(source.getSoldProducts()).setCount(0);
//            }
//        });

        List<UserDto> users = this.userRepository
                .findAllWithMoreThanOneSoldProductOrderByNumberProductsSoldThanLastName()
                .stream().map(user -> {
                    UserDto userDto = this.modelMapper.map(user, UserDto.class);
                    userDto.getSoldProducts()
                            .setCount(userDto.getSoldProducts().getProducts().size());

                    return userDto;
                })
                .collect(Collectors.toList());
        // int count = users.size();

//        this.modelMapper.addMappings(new PropertyMap<User, UserAndProductsDto>() {
//            @Override
//            protected void configure() {
//                map().setUsersCount(count);
//                map().setUsers(users);
//            }
//        });
//

        UserAndProductsDto userAndProductsDto = new UserAndProductsDto();
        userAndProductsDto.setUsersCount(users.size());
        userAndProductsDto.setUsers(users);

        return userAndProductsDto;
    }
}
