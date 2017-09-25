
/**
 * Write a description of class stack here.
 * 
 * @author Patrick Taylor
 * @version 1.0
 */
public class Stack
{
    Node top;
    public void push(Node n){
        
        n.setNext(top);
        top = n;

    }

    public Node pop(){
        Node popping = top;
        top = top.getNext();
        return popping;
    }

    public Node peek(){
        return top;
    }

}
