package TrafficLights_4;

public class Light {
    private Colors color;

    public Light(Colors color) {
        this.color = color;
    }

    public void changeColor() {
        switch (color) {
            case RED:
                color = Colors.GREEN;
                break;
            case GREEN:
                color = Colors.YELLOW;
                break;
            case YELLOW:
                color = Colors.RED;
                break;
        }
    }

    public Colors getColor() {
        return color;
    }
}