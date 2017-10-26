import java.util.*;
/**
 * Write a description of class BST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BST <T extends Comparable<T>>
{
    BSTNode <T> root;
    BSTNode <T> curr = root;
    public void insert(T insertMe){
        
        /*if(curr == null){
        curr.set(insertMe);
        }
        else if(insertMe.compareTo(curr.getc()) < 0){
            curr = getLeft();
            insert(insertMe);
        } else if(insertMe.compareTo(curr.getc()) > 0){
            curr = getRight();
            insert(insertMe);
        }*/
    }
    public void inOrderPrint(){
        
    }
    public boolean exists(T checkMe){
        return true;
    }
    public class BSTNode <X>
    {
        X val;
        BSTNode left;
        BSTNode right;

        BSTNode getLeft() {
            return left;
        }

        BSTNode getRight() {
            return right;
        }

        void setLeft(BSTNode bn) {
            left = bn;
        }

        void setRight(BSTNode bn) {
            right = bn;
        }

        X get() {
            return val;
        }

        void set(X v) {
            val = v;
        }

        //need a version of get that returns a comparable object,
        //because compareTo won't work on generic types by default
        //use get when you need to access the value, use getc
        //when you need to do a comparison
        //This will crash if a non-comparable object is used.
        Comparable getc() {return (Comparable) val;}
    }
}
