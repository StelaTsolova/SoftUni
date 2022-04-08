package com.example.exercisexmlprocessing.services.impls;

import com.example.exercisexmlprocessing.models.dtos.usersAndProducts.UserProductsDto;
import com.example.exercisexmlprocessing.models.dtos.usersAndProducts.UserProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.successfullySoldProducts.UserSoldProductsDto;
import com.example.exercisexmlprocessing.models.dtos.successfullySoldProducts.UserSoldProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.UserSeedDto;
import com.example.exercisexmlprocessing.models.entities.User;
import com.example.exercisexmlprocessing.repositories.UserRepository;
import com.example.exercisexmlprocessing.services.UserService;
import com.example.exercisexmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ValidationUtil validator, ModelMapper modelMapper, UserRepository userRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public long getEntityCount() {
        return this.userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users.stream().filter(this.validator::isValid)
                .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                .forEach(this.userRepository::save);
    }

    public User findRandomUser() {
        return this.userRepository.findById(ThreadLocalRandom.current()
                .nextLong(1, this.userRepository.count() + 1)).orElseThrow();
    }

    @Override
    public UserSoldProductsRootDto getUserSoldProductsRootDto() {
        UserSoldProductsRootDto rootDto = new UserSoldProductsRootDto();

        rootDto.setUsers(this.userRepository.findAllWithAtLeastOneSoldOrderByLastNameThanFirstName()
                .stream().map(user -> this.modelMapper.map(user, UserSoldProductsDto.class))
                .collect(Collectors.toList()));

        return rootDto;
    }

    @Override
    public UserProductsRootDto getUserProductsRootDto() {
        UserProductsRootDto rootDto = new UserProductsRootDto();

        List<User> users = this.userRepository.findAllWithAtLeastOneSoldOrderByProductsCountDescThanLastName();

        rootDto.setCount(users.size());
        rootDto.setUsers(users.stream().map(user -> {
                    UserProductsDto dto = this.modelMapper.map(user, UserProductsDto.class);
                    dto.getSoldProducts().setCount(dto.getSoldProducts().getProducts().size());

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
