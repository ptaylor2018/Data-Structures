import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Parents here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parents
{
    public static void main (String args []){
        try{
        Scanner scan = new Scanner(new BufferedReader(new FileReader("parens.txt")));
        String text = scan.nextLine();
        Stack<String> parents = new Stack<String>();
       // ArrayList<String> chars = new ArrayList<String>();
        boolean crap = false;
        for(int i = 0; i<text.length();i++){
            //scores.add(text.substring(i,i+1));
            //System.out.println(text.substring(i,i+1));
            if(text.substring(i,i+1).equals("(")){
                //System.out.println("cake");
                parents.push("(");
            } else if (text.substring(i,i+1).equals(")")){
                 String test = parents.pop();
                if(test == null){
                    System.out.println("Too many closing parenthesis");
                    crap = true;
                    break;
                }
            }
        
        }
        if(parents.pop() != null){
            System.out.println("Too many opening parenthesis");
        } else if(crap != true ){
            System.out.println("All good");
        }
        
    } catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
    }
}
