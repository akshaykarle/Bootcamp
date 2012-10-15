package org.twu.shape;
//Job: Understands four-sided shape with adjacent edges at 90 degrees

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return length + width + length + width;
    }

    public String draw(String pattern) {
        String drawing = "";
        for(int row = 1; row <= width; row++){
            for (int column = 1; column <= length; column++){
                drawing += pattern;
            }
            drawing += "\n";
        }
        return drawing;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null || other.getClass() != this.getClass()){
            return false;
        }
        Rectangle that = (Rectangle)other;
        return this.length == that.length && this.width == that.width;
    }

    @Override
    public int hashCode() {
        return new Integer((int)(length + width)).hashCode();
    }

    public static Rectangle asSquare(int side) {
        return new Rectangle(side, side);
    }
}
