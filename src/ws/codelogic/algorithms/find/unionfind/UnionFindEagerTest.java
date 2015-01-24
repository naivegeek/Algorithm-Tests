package ws.codelogic.algorithms.find.unionfind;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindEagerTest {

    private UnionFind unionFind;

    @Test
    public void testUnion() throws Exception {
        unionFind = UnionFindFactory.makeEager(10);
        unionFind.union(0,1);
        assertTrue("A connection is wrong in UnionFind ", unionFind.connected (0, 1));
    }

    @Test
    public void testConnected () throws Exception {

    }
}