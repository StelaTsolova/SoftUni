package PointInRectangle_2;

public class Rectangle {
    private Point A;
    private Point B;

    public Rectangle(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    public boolean contains(Point point) {
        return point.greaterOrEqual(A) && point.lessOrEqual(B);
    }
}