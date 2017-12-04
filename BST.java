import java.util.*;

import java.util.LinkedList;
import java.util.Queue;
/**
 * BST
 * Binary Search Tree class inteded to store data in a Binary Search Tree. The object in the generic
 * class must be comparable (implements Comparable). For the prints to work, the object must be
 * printable as well (implements toString()).
 * 
 * Seperate, recursive methods are used to implement recursive algorithms for operations.
 * This is because most recursive methods require the parent to be a parameter, but
 * generally when you call a method (like insert for example) the parent is assumed to
 * be the root.
 */
public class BST <T> {
    BSTNode <T> root;

    /**
     * insert a single element into the tree. It is potentially possible to mess up the tree by modifying an element after insertion.
     * @param in the element to insert (the actual instance is inserted, NOT A CLONE)
     */
    public void insert(T in) {
        if (in == null) return;
        BSTNode <T> bin = new BSTNode<T>();
        bin.set(in);
        if (root == null) {
            root = bin;
        } else {
            insert_re(root, bin);
        }
    }

    private void insert_re(BSTNode parent, BSTNode insertMe) {
        if (parent.getc().compareTo(insertMe.getc()) > 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(insertMe);
            } else {
                insert_re(parent.getLeft(), insertMe);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(insertMe);
            } else {
                insert_re(parent.getRight(), insertMe);
            }
        }
    }

    /**
     * in order traversal of the tree, using println to output the elements
     */
    public void inOrderPrint() {
        if (root != null) {
            inOrderPrint_re(root);
        }
    }

    private void inOrderPrint_re(BSTNode<T> parent) {
        if (parent == null) return;
        inOrderPrint_re(parent.getLeft());
        System.out.println(parent.get());
        inOrderPrint_re(parent.getRight());
    }

    private void inOrderArray_re(BSTNode<T> parent, ArrayList<BSTNode> list ) {
        if (parent == null) return;
        inOrderArray_re(parent.getLeft(), list);
        list.add(parent);
        inOrderArray_re(parent.getRight(), list);
    }

    /**
     * See if an element exists in the tree
     * @param q element to search for in the tree
     * @return true if an element in the tree is equal to the q, false otherwise
     */
    public boolean exists(T q) {
        return exists_re(q,root);
    }

    private boolean exists_re(T q, BSTNode<T> parent) {
        if (parent == null) return false;
        if (((Comparable)q).compareTo(parent.getc()) == 0) { //Typecasting shenanigans necessary for compareTo to work
            return true;
        } else if (((Comparable)q).compareTo(parent.getc()) < 0) {
            return exists_re(q, parent.getLeft());
        } else {
            return exists_re(q, parent.getRight());
        }
    }

    /**
     * print out tree with layers
     * 
     * @return nothing
     */
    public void printTree(){
        Queue<BSTNode> nodes = new LinkedList<>();
        BSTNode<T> completionNode = root;
        BSTNode<T> curr = root;
        nodes.add(curr);
        while(nodes.size() > 0){

            System.out.print(curr.get()+ "\t");
            if(curr.getLeft() != null){
                nodes.add(curr.getLeft());
            }
            if(curr.getRight() != null){
                nodes.add(curr.getRight());
            }
            if(curr == completionNode){
                System.out.print("\r\n");
                Queue<BSTNode> flipNodes = new LinkedList<>();
                while(nodes.size() > 1){
                    flipNodes.add(nodes.remove());
                }
                completionNode = nodes.peek();
                flipNodes.add(nodes.remove());
                while(flipNodes.size() > 0){
                    nodes.add(flipNodes.remove());
                }
            }

            nodes.remove();

            curr = nodes.peek();
        }

    }

    /**
     * blanace the tree
     * 
     * @return nothing
     */
    public void balance(){

        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        if (root != null) {
            inOrderArray_re(root, list);
        }

        root = balance_re(list);

    }

    /**
     * do the actual balancing
     * @param list list of all values in inOrder order
     * @return node
     */
    private BSTNode balance_re(ArrayList<BSTNode> list){
        if(list.isEmpty()){
            return null;
        }
        BSTNode<T> returnMe =  new BSTNode<T>();
        int median = (int)(list.size()/2.0);
        returnMe = list.get(median);
        ArrayList<BSTNode> list_left = new ArrayList<BSTNode>();
        ArrayList<BSTNode> list_right = new ArrayList<BSTNode>();
        for(int i = 0; i<median; i++){
            list_left.add(list.get(i));
        }
        for(int i = median+1; i < list.size(); i++){
            list_right.add(list.get(i));
        }

        returnMe.setLeft(balance_re(list_left));
        returnMe.setRight(balance_re(list_right));
        return returnMe;
    }
    public class BSTNode <X>
    {
        X val;

        BSTNode left;
        BSTNode right;

        BSTNode getLeft() {return left;}

        BSTNode getRight() {return right;}

        void setLeft(BSTNode bn) {left = bn;}

        void setRight(BSTNode bn) {right = bn;}

        X get() {return val;}

        void set(X v) {val = v;}

        Comparable getc() { return (Comparable) val;}
    }
}

