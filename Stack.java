
/**
 * Write a description of class stack here.
 * Makes a stack
 * @author Patrick Taylor
 * @version 1.0
 */
<<<<<<< HEAD
public class Stack
{
    Node top;
=======
public class Stack <T>
{
    Node2<T> top;
>>>>>>> c8faf64709e4c99691c91d0c98b4be4c723a6759
    /**
     * @param Node to go on top of stack
     * @return nothing
     * adds argument Node to top of stack
     */
<<<<<<< HEAD
    public void push(Node n){ 
        n.setNext(n);
        //top = n;
=======
    public void push(T v){ 
        Node2<T> n = new Node2(v);
        n.setNext(top);
        top = n;
>>>>>>> c8faf64709e4c99691c91d0c98b4be4c723a6759
    }

    /**
     * @param nothing
     * @return top of stack
     *removes top from stack and returns it 
     */
<<<<<<< HEAD
    public Node pop(){
        Node popping = top;
        top = top.getNext();
        return popping;
=======
    public T pop(){
        if(top == null){
            return null;
        }
    
        Node2<T> popping = top;
        top = top.getNext();
        return popping.get();
>>>>>>> c8faf64709e4c99691c91d0c98b4be4c723a6759
    }

    /**
     * @param nothing
     * @return top of stack
     * see waht's on top 
     */
<<<<<<< HEAD
    public Node peek(){
        return top;
=======
    public T peek(){
        if(top == null){
            return null;
        }
        return top.get();
>>>>>>> c8faf64709e4c99691c91d0c98b4be4c723a6759
    }

}
