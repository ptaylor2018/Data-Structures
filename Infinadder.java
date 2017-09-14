import java.io.*;
import java.util.Scanner;
/**
 * Adds two integers of arbitrary length
 * 
 * @author Patrick Taylor 
 * @version 1.0
 */
public class Infinadder
{
    boolean carry = false;
  
    public static void main(String [] args) {
        try{
            //creates scanners to take in numbers
            Scanner scan1 = new Scanner(new BufferedReader(new FileReader("num1.txt"))).useDelimiter(",");
            Scanner scan2 = new Scanner(new BufferedReader(new FileReader("num2.txt"))).useDelimiter(",");
            Scanner shorter = scan1;
            Scanner longer = scan2;
            //sees which number is longer
            int size1 = 0;
            while(scan1.hasNext()) {
                size1++;
                scan1.next();
            }
            int size2 = 0;
            while(scan2.hasNext()) {
                size2++;
                scan2.next();
            }
            //reset scanners to take in values
            scan1.close();
            scan2.close();
            scan1 = new Scanner(new BufferedReader(new FileReader("num1.txt"))).useDelimiter(",");
            scan2 = new Scanner(new BufferedReader(new FileReader("num2.txt"))).useDelimiter(",");
            //make Scanners point to semantically correct scanner
            if(size2 < size1){
                shorter = scan2;
                longer = scan1;
            } else{
                shorter = scan1;
                longer = scan2;
            }
            Digit head = new Digit(scan1.nextInt() + scan2.nextInt());
            
            Digit curr = head;
            boolean carry = false; //check if a one needs to be carried, changes number to reflect
            if (curr.getDigit() >= 10){
                carry = true;
                head.setDigit(head.getDigit() - 10);
            }
            Digit prev = head;
            System.out.println(curr.getDigit());
            //iterates through short part adding and then leftover long part not adding, to prevent error
            while(shorter.hasNext()){
                if(carry){
                    curr.setNext(new Digit(shorter.nextInt() + longer.nextInt() + 1)); //adds one when a digit is carried
                }else{
                    curr.setNext(new Digit(shorter.nextInt() + longer.nextInt()));
                }
                curr = curr.getNext();
                if(curr.getDigit() >= 10){ 
                    carry = true;
                    curr.setDigit(curr.getDigit() - 10);
                } else {
                    carry = false;
                }
                
                
                curr.setPrev(prev);
                prev = curr;
            }
            while(longer.hasNext()){
                if(carry){
                    curr.setNext(new Digit(longer.nextInt() + 1));
                }else{
                    curr.setNext(new Digit(longer.nextInt()));
                }
                curr = curr.getNext();
                if(curr.getDigit() >= 10){
                    carry = true;
                    curr.setDigit(curr.getDigit() - 10);
                } else {
                    carry = false;
                }
                
                curr.setPrev(prev);
                prev = curr;
            }
            //add a one on to the end it it's been carried
            if(carry){ 
                curr.setNext(new Digit(1));
                curr = curr.getNext();
                curr.setPrev(prev);
                prev = curr;
            }
            while(curr != null) {
                System.out.print(curr.getDigit()); //print full list of nodes out
                curr = curr.getPrev();
            }

        } catch(Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
    } 
    
}
