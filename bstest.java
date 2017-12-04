
/**
 * Write a description of class bstest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bstest
{
    public static void main (String [] args){
        BST<Integer> testy = new BST<Integer>();
        testy.insert(3);
        testy.insert(4);
        testy.insert(10);
        testy.insert(15);
        testy.insert(22);
        testy.printTree();
        System.out.println("break");
        testy.balance();
        System.out.println("break");
        testy.printTree();
    }
}
