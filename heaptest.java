
/**
 * Write a description of class heaptest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class heaptest
{
   public static void main(String args[]){
    MinHeap test = new MinHeap();
    test.insert(7, 0);
    test.insert(12, 12);
    test.insert(49, 24);
    test.insert(3, 45);
    test.insert(31, 556);
    test.insert(4, 78);
    test.insert(2, 67);
    test.insert(5, 12);
    test.insert(87, 13);
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    System.out.println(test.delete());
    }
}
