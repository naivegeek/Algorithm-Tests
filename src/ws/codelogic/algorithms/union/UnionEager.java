package ws.codelogic.algorithms.union;

public class UnionEager implements Union<Integer> {

    private Integer[] array;

    protected UnionEager(Integer[] array){
        this.array = array;
    }

    @Override
    public void union(Integer object1, Integer object2) {
        int id1 = array[object1];
        int id2 = array[object2];
        for(int i=0;i<array.length;i++){
            if(array[i] == id2) array[i] = id1;
        }
    }

    @Override
    public boolean connected (Integer object1, Integer object2) {
        return isConnected(object1, object2);
    }

    private boolean isConnected(Integer int1, Integer int2){
        return array[int1].equals(array[int2]);
    }

}
