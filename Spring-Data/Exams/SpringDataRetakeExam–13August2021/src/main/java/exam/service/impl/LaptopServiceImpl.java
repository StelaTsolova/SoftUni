package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.json.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_NAME = "src/main/resources/files/json/laptops.json";

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final ShopService shopService;
    private final LaptopRepository laptopRepository;

    public LaptopServiceImpl(Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper,
                             ShopService shopService, LaptopRepository laptopRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.shopService = shopService;
        this.laptopRepository = laptopRepository;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_NAME));
    }

    @Override
    public String importLaptops() throws IOException {
        List<String> massages = new ArrayList<>();

        Arrays.stream(this.gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class))
                .filter(laptopSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(laptopSeedDto) && !isExistsByMacAddress(laptopSeedDto.getMacAddress());
                    if (isValid) {
                        massages.add(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                laptopSeedDto.getMacAddress(), laptopSeedDto.getCpuSpeed(),
                                laptopSeedDto.getRam(), laptopSeedDto.getStorage()));
                    } else {
                        massages.add("Invalid Laptop");
                    }

                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = this.modelMapper.map(laptopSeedDto, Laptop.class);
                    laptop.setShop(this.shopService.getShopByName(laptopSeedDto.getShop().getName()));

                    return laptop;
                })
                .forEach(this.laptopRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isExistsByMacAddress(String macAddress) {
        return this.laptopRepository.existsByMacAddress(macAddress);
    }

    @Override
    public String exportBestLaptops() {
        List<String> result = this.laptopRepository
                .findAllOrderByCpuSpeedDescRamDescStorageDescMaxAddress().stream()
                .map(laptop -> String.format("Laptop - %s%n*Cpu speed - %.2f%n**Ram - %d%n" +
                                "***Storage - %d%n****Price - %.2f%n#Shop name - %s%n" +
                                "##Town - %s%n", laptop.getMacAddress(), laptop.getCpuSpeed(),
                        laptop.getRam(), laptop.getStorage(), laptop.getPrice(),
                        laptop.getShop().getName(), laptop.getShop().getTown().getName())).toList();

        return String.join(System.lineSeparator(), result);
    }
}
