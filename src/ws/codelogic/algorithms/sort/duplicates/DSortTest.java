package ws.codelogic.algorithms.sort.duplicates;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DSortTest {

    private DSort sort;

    @Before
    public void setup() {
        sort = new DSort();
    }

    @Test
    public void testEasyDuplicateSort() {
        Integer[] unsorted = {8,7,9,7,8,7,9,8,8,9,7,9};
        Integer[] sorted = {7,7,7,7,8,8,8,8,9,9,9,9};
        testArray(unsorted, sorted);
    }

    @Test
    public void testMoreThen3TypeSort() {
        Integer[] unsorted = {3,2,1,5,5,3,1,2,4,2,4,3,5,1,4};
        Integer[] sorted = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5};
        testArray(unsorted, sorted);
    }

    private void testArray(Comparable[] unsorted, Comparable[] sorted){
        sort.sort(unsorted);
        Comparable[] newlySorted = unsorted;
        assertEquals(newlySorted, sorted);
    }
}
