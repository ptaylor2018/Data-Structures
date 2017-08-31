import java.io.*;
import java.util.Scanner;
public class FirstDay{
    public static void main(String args[]){
        try{    
            Scanner scan = new Scanner(new BufferedReader(new FileReader("balues.txt")));  
            int size = 0;
            while(scan.hasNext()) {
                size++;
                scan.next();
            }
            int[] values = new int[size];
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("balues.txt")));
            for(int i = 0; i < values.length; i++){
                values[i] = scan.nextInt();
            }
            int sum = 0;   
            for(int i = 0; i < values.length; i++){
                sum += values[i];
            }
            System.out.println(sum);	
        }catch (Exception e) {
            System.out.println("WAT: " + e.getMessage());
        }

    }
}