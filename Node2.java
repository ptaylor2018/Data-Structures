public class Node2 <T>
{
    T value;
    Node2 next;
    
    public Node2(T val) {
        value = val;
    }
    
    public T get() {
        return value;
    }
    public void set(T v) {
        value = v;
    }
    public Node2 getNext() {
        return next;
    }
    public void setNext(Node2 n) {
        next = n;
    }
}