package Shapes_2;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        Double perimeter = (2 * height) + (2 * width);
        setPerimeter(perimeter);
    }

    @Override
    protected void calculateArea() {
        Double area = height * width;
        setArea(area);
    }
}