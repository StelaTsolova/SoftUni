package exam.service.impl;

import exam.model.dto.xml.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOPS_FILE_NAME = "src/main/resources/files/xml/shops.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper,
                           TownService townService, ShopRepository shopRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.shopRepository = shopRepository;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_NAME));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        ShopSeedRootDto shopSeedRootDto = (ShopSeedRootDto) JAXBContext
                .newInstance(ShopSeedRootDto.class)
                .createUnmarshaller()
                .unmarshal(new FileReader(SHOPS_FILE_NAME));

        List<String> massages = new ArrayList<>();
        shopSeedRootDto.getShops().stream().filter(shopSeedDto -> {
            boolean isValid = this.validationUtil.isValid(shopSeedDto) && !isExistsByName(shopSeedDto.getName());
            if (isValid) {
                massages.add(String.format("Successfully imported Shop %s - %s",
                        shopSeedDto.getName(), shopSeedDto.getIncome()));
            } else {
                massages.add("Invalid Shop");
            }

            return isValid;
        }).map(shopSeedDto -> {
            Shop shop = this.modelMapper.map(shopSeedDto, Shop.class);
            shop.setTown(this.townService.getTownByName(shopSeedDto.getTown().getName()));

            return shop;
        }).forEach(this.shopRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isExistsByName(String name) {
        return this.shopRepository.existsByName(name);
    }

    @Override
    public Shop getShopByName(String name) {
        return this.shopRepository.findByName(name);
    }
}
