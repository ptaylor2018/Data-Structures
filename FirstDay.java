
/**
 * Takes integer values from file, adds them together, prints sum.
 * The values are stored in an array in the interim
 * @author Patrick Taylor 
 * @version 1.0
 */
import java.io.*;
import java.util.Scanner;
public class FirstDay{
    /**
     * @param String args[] allows for command line inputs
     * @return nothing, but pritns sum
     */
    public static void main(String args[]){
        //catches problems with reading the file
        try{
            //makes scanner to read file to count values
            Scanner scan = new Scanner(new BufferedReader(new FileReader("balues.txt")));
            int size = 0;
            //figures out the number of values in document
            while(scan.hasNext()) {
                size++;
                scan.next();
            }
            //makes array that values from file will be in
            int[] values = new int[size];
            scan.close();
            //restarts scanner to actually read valuse instead of counting them 
            scan = new Scanner(new BufferedReader(new FileReader("balues.txt")));
            //fills array with values
            for(int i = 0; i < values.length; i++){
                values[i] = scan.nextInt();
            }
            int sum = 0;  
            //sums values in array
            for(int i = 0; i < values.length; i++){
                sum += values[i];
            }
            //prints sum 
            System.out.println(sum);   
        //catches problems with reading the file    
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }

    }
}