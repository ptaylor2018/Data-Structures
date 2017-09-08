/**
 * Reads integer values from file, stores them in linked list
 * @author Patrick Taylor
 * @version 1.0
 */
import java.io.*;
import java.util.Scanner;
public class BetterNodeFun
{
    /**
     * @param String args[] allows for command line inputs
     * @return nothing, but prints list
     */
    public static void main(String [] args) {
        
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("nums.txt")));
            Node head = new Node(scan.nextInt()); //create initial node
            Node curr = head;
            while(scan.hasNext()){
                curr.setNext(new Node(scan.nextInt())); //create subsequent nodes
                curr = curr.getNext();
            }
            curr = head;
            while(curr != null) {
                System.out.println(curr.getValue()); //print full list of nodes out
                curr = curr.getNext();
            }
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
    }
}