package org.twu.shape;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RectangleTest {
    @Test
    public void shouldUnderstandAreaOfRectangle() throws Exception {
        double length = 5;
        double width = 3;
        Rectangle rectangle = new Rectangle(length, width);
        double area = rectangle.area();
        assertThat(area, is(15.0));
    }

    @Test
    public void shouldUnderstandTwoRectanglesMayHaveDifferentAreas() throws Exception {
        double firstLength = 5;
        double firstWidth = 3;
        Rectangle firstRectangle = new Rectangle(firstLength, firstWidth);

        double secondLength = 7;
        double secondWidth = 3;
        Rectangle secondRectangle = new Rectangle(secondLength, secondWidth);

        assertThat(firstRectangle.area(), is(not(secondRectangle.area())));
    }

    @Test
    public void shouldUnderstandPerimeterOfRectangle() throws Exception {
        double length = 9;
        double width = 6;
        Rectangle rectangle = new Rectangle(length, width);
        double perimeter = rectangle.perimeter();
        assertThat(perimeter, is(30.0));
    }

    @Test
    public void shouldUnderstandTwoRectanglesMayHaveDifferentPerimeters() throws Exception {
        double firstLength = 2;
        double firstWidth = 3;
        Rectangle firstRectangle = new Rectangle(firstLength, firstWidth);

        double secondLength = 8;
        double secondWidth = 5;
        Rectangle secondRectangle = new Rectangle(secondLength, secondWidth);

        assertThat(firstRectangle.perimeter(), is(not(secondRectangle.perimeter())));
    }

    @Test
    public void shouldUnderstandAreaOfSquare() throws Exception {
        int side = 7;
        Rectangle square = Rectangle.asSquare(side);
        double area = square.area();
        assertThat(area, is(49.0));
    }

    @Test
    public void shouldUnderstandPerimeterOfSquare() throws Exception {
        int side = 3;
        Rectangle square = Rectangle.asSquare(side);
        double perimeter = square.perimeter();
        assertThat(perimeter, is(12.0));
    }

    @Test
    public void shouldDrawRectangleWithStars() throws Exception {
        int length = 3;
        int width = 2;
        Rectangle rectangle = new Rectangle(length, width);
        String drawing = rectangle.draw("*");
        assertThat(drawing, is("***\n***\n"));
    }

    @Test
    public void shouldDrawRectangleWithDashes() throws Exception {
        int length = 3;
        int width = 2;
        Rectangle rectangle = new Rectangle(length, width);
        String drawing = rectangle.draw("-");
        assertThat(drawing, is("---\n---\n"));
    }

    @Test
    public void shouldUnderstandRectangleMayBeSquare() throws Exception {
        int length = 4;
        int width = length;
        Rectangle rectangle = new Rectangle(length, width);
        int side = 4;
        Rectangle square = Rectangle.asSquare(side);
        assertEquals(rectangle, square);
    }

    @Test
    public void shouldUnderstandRectangleMayNotBeSquare() throws Exception {
        int length = 7;
        int width = 4;
        Rectangle rectangle = new Rectangle(length, width);
        int side = 4;
        Rectangle square = Rectangle.asSquare(side);
        assertFalse(rectangle.equals(square));
    }

    @Test
    public void shouldUnderstandFigureMayNotEqualNull() throws Exception {
        int length = 8;
        int width = 3;
        Rectangle rectangle = new Rectangle(length, width);
        assertFalse(rectangle.equals(null));
    }

    @Test
    public void shouldUnderstandFigureMayNotEqualOfDifferentType() throws Exception {
        int length = 4;
        int width = 7;
        Rectangle rectangle = new Rectangle(length, width);
        assertFalse(rectangle.equals(new String("rectangle: 4,7")));
    }

    @Test
    public void shouldUnderstandTwoEqualFigureHaveSameHashCode() throws Exception {
        int firstLength = 5;
        int firstWidth = 3;
        Rectangle firstRectangle = new Rectangle(firstLength, firstWidth);
        int firstHashcode = firstRectangle.hashCode();

        int secondLength = 3;
        int secondWidth = 5;
        Rectangle secondRectangle = new Rectangle(secondLength, secondWidth);
        int secondHashcode = secondRectangle.hashCode();

        assertThat(firstHashcode, is(secondHashcode));
    }
}
