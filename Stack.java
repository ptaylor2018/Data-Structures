
/**
 * Write a description of class stack here.
 * Makes a stack
 * @author Patrick Taylor
 * @version 1.0
 */
public class Stack
{
    Node top;
    /**
     * @param Node to go on top of stack
     * @return nothing
     * adds argument Node to top of stack
     */
    public void push(Node n){ 
        n.setNext(n);
        //top = n;
    }

    /**
     * @param nothing
     * @return top of stack
     *removes top from stack and returns it 
     */
    public Node pop(){
        Node popping = top;
        top = top.getNext();
        return popping;
    }

    /**
     * @param nothing
     * @return top of stack
     * see waht's on top 
     */
    public Node peek(){
        return top;
    }

}
