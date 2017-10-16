import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class PolishParser here.
 * Parses polish notation
 * @author Patrick taylor 
 * @version 1.0
 */
public class PolishParser
{
    public static void main(String args[]){
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("polish.txt")));
            Stack<String> parsing = new Stack<String>();
            while(scan.hasNext()){
                
                String value = scan.next();
                //System.out.println(value);
                if(value.equals("*") || value.equals("/") || value.equals("+") || value.equals("-")){
                    String operator = value;
                    float first = Float.parseFloat(parsing.pop());
                    float second = Float.parseFloat(parsing.pop());
                    switch (operator){
                        case "*": parsing.push(Float.toString(second * first));
                        break;
                        case "/": parsing.push(Float.toString(second / first));
                        break;
                        case "+": parsing.push(Float.toString(second + first));
                        break;
                        case "-": parsing.push(Float.toString(second - first));
                        break;
                    }
                }else if (isNumeric(value)){
                    parsing.push(value);
                } else {
                    System.out.println("your input is bad!");
                    break;
                }
            }
            System.out.println(parsing.peek());
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
    }
/**
 * checks if numeric
 * @param string to check if numeric
 * @return boolean, true if numeric
 */
    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }
}
