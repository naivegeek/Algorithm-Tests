package ws.codelogic.algorithms.union;

public class QuickUnion implements Union<Integer> {

    private Integer[] array;

    protected QuickUnion(Integer[] array){
        this.array = array;
    }

    @Override
    public void union(Integer object1, Integer object2){
        array[findRoot(object1)] = findRoot(object2);
    }

    private int findRoot(int index){
        while(index != array[index]){
            index = array[index];
        }
        return index;
    }

    @Override
    public boolean connected (Integer object1, Integer object2) {
        return findRoot(object1) == findRoot(object2);
    }

}
