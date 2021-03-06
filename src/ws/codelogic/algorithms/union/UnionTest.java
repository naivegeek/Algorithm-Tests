package ws.codelogic.algorithms.union;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnionTest {

    Union<Integer> union;

    @Test
    public void testUnion() throws Exception {

        union = UnionFactory.makeEager(10);
        testUnionConnection();

        union = UnionFactory.makeQuickUnion(10);
        testUnionConnection();

        union = UnionFactory.makeQuickUnionWeighted(10);
        testUnionConnection();

        union = UnionFactory.makeQuickUnionPathCompression(10);
        testUnionConnectionWorstCase();

    }

    private void testUnionConnection(){
        union(0, 1);
        union(1, 2);
        union(0, 3);
        union(9, 5);
        union(5, 8);
        union(8, 6);
        union(6, 7);
        connectedTrue(0, 1);
        connectedTrue(0, 3);
        connectedFalse(0, 4);
        connectedFalse(8, 4);
        connectedTrue(7, 5);
        connectedTrue(5, 9);
        connectedTrue(8, 6);
    }

    private void testUnionConnectionWorstCase(){
        union(0,1);
        union(1, 2);
        union(2,3);
        union(3,4);
        union(4,5);
        union(5,6);
        union(6,7);
        union(7,0);
        union(8,9);
        union(9,0);
        connectedTrue(0, 3);
        connectedTrue(7, 5);
        connectedTrue(5, 9);
        connectedTrue(8, 6);
        connectedTrue(0,9);
    }

    private void union(int int1, int int2){
        union.union(int1, int2);
    }

    private void connectedTrue(int int1, int int2){
        boolean isThereUnion = union.connected (int1, int2);
        assertTrue(int1 + " should have been united with " + int2, isThereUnion);
    }

    private void connectedFalse(int int1, int int2){
        boolean isNoUnion = !union.connected (int1, int2);
        assertTrue(int1 + " should not be united with " + int2, isNoUnion);
    }

}