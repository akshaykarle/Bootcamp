package org.twu.shape;
//Job: 

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PerimeterBasedSortTest {
    @Test
    public void shouldSortRectangleBasedOnPerimeter() throws Exception {
        int length1 = 10;
        int width1 = 4;
        Rectangle biggestRectangle = new Rectangle(length1, width1);

        int length2 = 6;
        int width2 = 7;
        Rectangle mediumRectangle = new Rectangle(length2, width2);

        int length3 = 3;
        int width3 = 2;
        Rectangle smallestRectangle = new Rectangle(length3, width3);

        List<Rectangle> rectangles = new ArrayList<Rectangle>();
        rectangles.add(biggestRectangle);
        rectangles.add(smallestRectangle);
        rectangles.add(mediumRectangle);

        List<Rectangle> sortedRectangles = new ArrayList<Rectangle>();
        sortedRectangles.add(smallestRectangle);
        sortedRectangles.add(mediumRectangle);
        sortedRectangles.add(biggestRectangle);

        PerimeterBasedSort sorter = new PerimeterBasedSort();
        sorter.sort(rectangles);
        assertEquals(sortedRectangles, rectangles);
    }
}
