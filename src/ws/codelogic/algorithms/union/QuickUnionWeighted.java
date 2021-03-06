package ws.codelogic.algorithms.union;

public class QuickUnionWeighted implements Union<Integer>{
    private Integer[] branchPointer;
    private Integer[] treeSize;

    private int root1;
    private int root2;
    private int size1;
    private int size2;
    private int object1;
    private int object2;

    protected QuickUnionWeighted(Integer[] branchPointer, Integer[] treeSize){
        this.branchPointer = branchPointer;
        this.treeSize = treeSize;
    }

    @Override
    public void union(Integer object1, Integer object2){
        root1 = findRoot(object1);
        root2 = findRoot(object2);
        size1 = treeSize[object1];
        size2 = treeSize[object2];
        this.object1 = object1;
        this.object2 = object2;
        if(root1 == root2) return;
        if(size1 > size2){
            mergeTree1To2();
        }else{
            mergeTree2To1();
        }
    }

    private void mergeTree1To2(){
        branchPointer[object2] = root1;
        treeSize[object2] += treeSize[object1];
    }

    private void mergeTree2To1(){
        branchPointer[object1] = root2;
        treeSize[object1] += treeSize[object2];
    }

    private int findRoot(int index){
        while(index != branchPointer[index]){
            index = branchPointer[index];
        }
        return index;
    }

    @Override
    public boolean connected (Integer object1, Integer object2) {
        return findRoot(object1) == findRoot(object2);
    }

}
