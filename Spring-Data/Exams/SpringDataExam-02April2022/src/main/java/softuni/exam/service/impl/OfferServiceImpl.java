package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.ApartmentSeedRootDto;
import softuni.exam.models.dto.xml.OfferSeedRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_FILE_NAME = "src/main/resources/files/xml/offers.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    private final OfferRepository offerRepository;

    public OfferServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper,
                            AgentService agentService, ApartmentService apartmentService,
                            OfferRepository offerRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.offerRepository = offerRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_NAME));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        OfferSeedRootDto offerSeedRootDto = (OfferSeedRootDto) JAXBContext
                .newInstance(OfferSeedRootDto.class)
                .createUnmarshaller()
                .unmarshal(new FileReader(OFFERS_FILE_NAME));

        List<String> massages = new ArrayList<>();
        offerSeedRootDto.getOffers().stream().filter(offerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(offerSeedDto)
                            && isExistsAgentName(offerSeedDto.getAgent().getName());
                    if (isValid) {
                        massages.add(String.format("Successfully imported offer %.2f",
                                offerSeedDto.getPrice()));
                    } else {
                        massages.add("Invalid offer");
                    }

                    return isValid;
                })
                .map(offerSeedDto -> {
                    Offer offer = this.modelMapper.map(offerSeedDto, Offer.class);
                    offer.setAgent(this.agentService.getAgentByFirstName(offerSeedDto.getAgent().getName()));
                    offer.setApartment(this.apartmentService.getApartmentById(offerSeedDto.getApartment().getId()));

                    return offer;
                })
                .forEach(this.offerRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isExistsAgentName(String agentName) {
        return this.agentService.isExistsByFirstName(agentName);
    }

    @Override
    public String exportOffers() {
      StringBuilder information = new StringBuilder();
        this.offerRepository.findAllWithTreeRoomsOrderByAreaDescThenByPrice()
                .forEach(offer -> information.append(String.format("Agent %s %s with offer №%d:%n" +
                                "\t-Apartment area: %.2f%n\t--Town: %s%n\t---Price: %.2f$%n",
                        offer.getAgent().getFirstName(), offer.getAgent().getLastName(),
                        offer.getId(), offer.getApartment().getArea(),
                        offer.getApartment().getTown().getTownName(),
                        offer.getPrice())));

        return information.toString();
    }
}
