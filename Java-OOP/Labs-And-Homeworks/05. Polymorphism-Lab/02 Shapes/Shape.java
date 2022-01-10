package Shapes_2;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    public Double getPerimeter() {
        if (this.perimeter == null) {
            calculatePerimeter();
        }
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        if (this.area == null) {
            calculateArea();
        }
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }
}