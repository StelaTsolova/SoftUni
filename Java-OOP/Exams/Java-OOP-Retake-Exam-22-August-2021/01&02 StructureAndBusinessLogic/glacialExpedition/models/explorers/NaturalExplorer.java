package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        double newEnergy = super.getEnergy() - 7;

        if (newEnergy < 0){
            super.setEnergy(0);
        } else {
            super.setEnergy(newEnergy);
        }
    }
}
