
/**
 * Write a description of class stack here.
 * Makes a stack
 * @author Patrick Taylor
 * @version 1.0
 */
public class Stack <T>
{
    Node2<T> top;
    /**
     * @param Node to go on top of stack
     * @return nothing
     * adds argument Node to top of stack
     */
    public void push(T v){ 
        Node2<T> n = new Node2(v);
        n.setNext(top);
        top = n;
    }

    /**
     * @param nothing
     * @return top of stack
     *removes top from stack and returns it 
     */
    public T pop(){
        if(top == null){
            return null;
        }
    
        Node2<T> popping = top;
        top = top.getNext();
        return popping.get();
    }

    /**
     * @param nothing
     * @return top of stack
     * see waht's on top 
     */
    public T peek(){
        if(top == null){
            return null;
        }
        return top.get();
    }

}
