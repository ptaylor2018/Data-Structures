import java.util.*;
/**
 * BST
 * 
 * @author Patrick Taylor
 * @version 1.0
 */
public class BST <T extends Comparable<T>>
{
    BSTNode <T> root;
    BSTNode <T> curr = root;
    public void insert(T insertMe){
        BSTNode <T> toInsert =null;
        toInsert.set(insertMe);

        if (curr.get() ==null){
            curr.set(insertMe);
        }else if(toInsert.getc().compareTo(curr.getc()) < 0){
            curr = curr.getLeft();
            insert(insertMe);
        } else if(toInsert.getc().compareTo(curr.getc()) > 0){
            curr = curr.getRight();
            insert(insertMe);
        }
        
    }

    public void inOrderPrint(){
        if(curr != null){
            curr = curr.getLeft();
            inOrderPrint();
            System.out.println(curr.get());
            curr = curr.getRight();
            inOrderPrint();
        }

    }
    public boolean exists(T checkMe){
        BSTNode <T> toCheck =null;
        toCheck.set(checkMe);
        if(curr != null){
            curr = curr.getLeft();
            exists(checkMe);
            if(curr.getc().compareTo(toCheck.getc()) == 0){
                return true;
            }
            curr = curr.getRight();
            exists(checkMe);
        }
        return false;
    }
    public class BSTNode <X extends Comparable<X>>
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
