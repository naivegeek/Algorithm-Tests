package ws.codelogic.algorithms.union;

public class QuickUnionPathCompression implements Union<Integer> {

    private Integer[] array;
    private int iterations = 0;

    protected QuickUnionPathCompression(Integer[] array){
        this.array = array;
    }

    @Override
    public void union(Integer object1, Integer object2){
        array[findRoot(object1)] = findRoot(object2);
        System.out.println("Debug-QuickUnionCompression: iterations " + iterations);
        printDebug();
    }

    private int findRoot(int index){
        while(index != array[index]){
            pushNodeUpTheTree(index);
            index = array[index];
            iterations++;
        }
        return index;
    }

    private void pushNodeUpTheTree(int index){
        int nextNode = array[index];
        array[index] = array[nextNode];
        System.out.println("element" + index + " should point " + array[nextNode]);
    }

    @Override
    public boolean connected (Integer object1, Integer object2) {
        return findRoot(object1) == findRoot(object2);
    }

    private void printDebug(){
        System.out.println("Debug-QuickUnionPathCompression");
        for(int i=0;i<array.length;i++){
            System.out.println("El: " + i + " Pnt: " + array[i]);
        }
    }

}
