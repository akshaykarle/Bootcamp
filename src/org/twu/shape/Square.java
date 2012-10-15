package org.twu.shape;
//Job: Understands four-sided shape with equal adjacent edges at 90 degrees

public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}
