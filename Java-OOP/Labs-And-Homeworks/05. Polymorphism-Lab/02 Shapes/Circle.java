package Shapes_2;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        Double perimeter = 2 * Math.PI + this.radius;
    }

    @Override
    protected void calculateArea() {
        Double area = Math.PI * this.radius * this.radius;
    }
}