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
        System.out.println(maze.length);
        System.out.println(maze[0].length);
        // System.out.println(maze[1].length);
        for(int j = 0; j <maze[0].length; j++){
            for(int i = 0; i <  maze.length; i++){
                if(maze[i][j].equals("@")){
                    startPosX = i;
                    startPosY = j;
                    System.out.println(i+" "+j);

                }
            }
        }
        int [] firstPos = {startPosX,startPosY};
        boolean notDone = true;
        int xPos = startPosX;
        int yPos = startPosY;
        Stack<int[]> path =  new Stack<int[]>();   
        path.push(firstPos);
        while(notDone){
            if(yPos+1 >= 0 && yPos + 1 < maze[0].length && xPos >= 0 && xPos <maze.length){
                
                if((maze[xPos][yPos + 1].equals(".")||maze[xPos][yPos + 1].equals("$"))){
                    maze[xPos][yPos] = "x";
                    xPos = xPos;
                    yPos = yPos + 1;
                    int[] thePos = {xPos,yPos};
                    path.push(thePos);
                    if(maze[xPos][yPos].equals("$")){
                        notDone = false;
                    }

                }
            }
            else if(yPos-1 >= 0 && yPos - 1 < maze[0].length && xPos >= 0 && xPos <maze.length){
                System.out.println("the");
                if(maze[xPos][yPos-1].equals(".")||maze[xPos][yPos-1].equals("$")){
                    maze[xPos][yPos] = "x";
                    xPos = xPos;
                    yPos = yPos - 1;
                    int[] thePos = {xPos,yPos};
                    path.push(thePos);
                    if(maze[xPos][yPos].equals("$")){
                        notDone = false;
                    }

                }
            }
            else if((yPos >= 0) && (yPos < maze[0].length) && (xPos-1 >= 0) && (xPos-1 <maze.length)){
                if(maze[xPos - 1][yPos].equals(".")||maze[xPos - 1][yPos].equals("$")){
                    maze[xPos][yPos] = "x";
                    xPos = xPos - 1;
                    yPos = yPos;
                    int[] thePos = {xPos,yPos};
                    path.push(thePos);
                    if(maze[xPos][yPos].equals("$")){
                        notDone = false;
                    }

                }
            }
            else if((yPos >= 0) && (yPos < maze[0].length) && (xPos+1 >= 0) && (xPos+1 <maze.length)){
                if(maze[xPos + 1][yPos].equals(".")||maze[xPos + 1][yPos].equals("$")){
                    maze[xPos][yPos] = "x";
                    xPos = xPos + 1;
                    yPos = yPos;
                    int[] thePos = {xPos,yPos};
                    path.push(thePos);
                    if(maze[xPos][yPos].equals("$")){
                        notDone = false;
                    }

                }
            }
            else{
                path.pop();
            }
        }
        Stack<int[]> printPath =  new Stack<int[]>();
        while(path.peek() != null){
            int[] value = path.pop();
            printPath.push(value);
        }
        while(printPath.peek() != null){
            int[]value = printPath.pop();
            System.out.println(value[1] +","+ value[0]);
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
