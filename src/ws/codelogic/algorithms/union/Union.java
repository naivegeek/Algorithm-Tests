package ws.codelogic.algorithms.union;

public interface Union<T>{
    public void union(T object1, T object2);
    public boolean connected (T object1, T object2);
}
