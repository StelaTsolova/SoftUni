package PizzaCalories_4;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double caloriesFlourType = getCalories(this.flourType);
        double caloriesBakingTechnique = getCalories(this.bakingTechnique);
        return (2 * this.weight) * caloriesFlourType * caloriesBakingTechnique;
    }

    private double getCalories(String info) {
        switch (info) {
            case "White":
                return 1.5;
            case "Wholegrain":
            case "Homemade":
                return 1.0;
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
        }
        return 0;
    }
}