import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Amazeing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Amazeing
{
    // instance variables - replace the example below with your own
    public static void main(String args[]){
        String[][] maze = makeArray();
        int startPosX = 0;
        int startPosY = 0;
        for(int j = 0; j < arrayHeight; j++){
                for(int i = 0; i < arrayWidth; i++){
                    if(maze[i][j].equals("@"){
                        startPosX = i;
                        startPosY = j;
                    }
                }
                System.out.println("");
            }
    }

    public static String[][] makeArray(){
        String[][] placeholder = new String[1][1];
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            String firstLine = scan.nextLine();
            int arrayWidth = firstLine.length();
            System.out.println(arrayWidth);
            int arrayHeight = 0;
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            while(scan.hasNextLine()){
                String throwaway = scan.nextLine();
                arrayHeight++;
            }
            System.out.println(arrayHeight);
            scan.close();
            String[][] maze = new String[arrayWidth][arrayHeight];
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));

            for(int j = 0; scan.hasNextLine(); j++){
                String texto = scan.nextLine();
                for(int i = 0; i < texto.length(); i++){
                    maze[i][j] = texto.substring(i,i+1);
                }

            }
            for(int j = 0; j < arrayHeight; j++){
                for(int i = 0; i < arrayWidth; i++){
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
            placeholder = maze;
            return maze;
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
        return placeholder;
    }
}
