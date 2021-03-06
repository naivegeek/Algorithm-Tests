package ws.codelogic.algorithms.union;

public class QuickUnionPathCompression implements Union<Integer> {

    private Integer[] array;

    protected QuickUnionPathCompression(Integer[] array){
        this.array = array;
    }

    @Override
    public void union(Integer object1, Integer object2){
        array[findRoot(object1)] = findRoot(object2);
    }

    private int findRoot(int index){
        while(index != array[index]){
            pushNodeUpTheTree(index);
            index = array[index];
        }
        return index;
    }

    private void pushNodeUpTheTree(int index){
        int nextNode = array[index];
        array[index] = array[nextNode];
    }

    @Override
    public boolean connected (Integer object1, Integer object2) {
        return findRoot(object1) == findRoot(object2);
    }

}
