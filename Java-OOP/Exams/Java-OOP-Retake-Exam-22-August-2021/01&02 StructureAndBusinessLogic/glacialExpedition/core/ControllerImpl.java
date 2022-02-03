package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        //int explorersCount = this.explorerRepository.getCollection().size();

        List<Explorer> suitableExplorers = explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableExplorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(this.stateRepository.byName(stateName), suitableExplorers);

        long retired = suitableExplorers.stream().filter(e -> e.getEnergy() == 0).count();

        this.exploredStatesCount++;

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStatesCount));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(ConstantMessages.FINAL_EXPLORER_INFO);

        for (Explorer explorer : this.explorerRepository.getCollection()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                stringBuilder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }

        return stringBuilder.toString();
    }
}
