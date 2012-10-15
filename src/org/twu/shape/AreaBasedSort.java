package org.twu.shape;
//Job: Understands how to order rectangles based on their areas

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AreaBasedSort implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle firstRectangle, Rectangle secondRectangle) {
        return (int) (firstRectangle.area() - secondRectangle.area());
    }

    public void sort(List<Rectangle> rectangles) {
        Collections.sort(rectangles, new AreaBasedSort());
    }
}
