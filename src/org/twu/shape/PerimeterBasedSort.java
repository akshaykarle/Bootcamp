package org.twu.shape;
//Job: Understands how to order rectangles based on their perimeter

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PerimeterBasedSort implements Comparator<Rectangle> {

    public void sort(List<Rectangle> rectangles) {
        Collections.sort(rectangles, new PerimeterBasedSort());
    }

    @Override
    public int compare(Rectangle firstRectangle, Rectangle secondRectangle) {
        return (int) (firstRectangle.perimeter() - secondRectangle.perimeter());
    }
}
