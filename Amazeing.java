import java.io.*;
import java.util.Scanner;
/**
 * Solves mazes
 * 
 * @author Patrick Taylor
 * @version 1.0
 */
public class Amazeing
{
    static int mazeX = 0; //for referencing maze size in global context for methods
    static int mazeY = 0;
    
    public static void main(String args[]){
        String[][] maze = makeArray(); //turns maze into array for traversal
        int startPosX = 0;
        int startPosY = 0;
        
        //determines starting position in maze
        for(int j = 0; j <maze[0].length; j++){
            for(int i = 0; i <  maze.length; i++){
                if(maze[i][j].equals("@")){
                    startPosX = i;
                    startPosY = j;
                }
            }
        }
        int [] firstPos = {startPosX,startPosY}; //store coords in arrays
        boolean notDone = true; //to tell if it has a solution or not
        int xPos = startPosX; //set moving point to start at the maze start
        int yPos = startPosY;
        mazeX = maze.length; //make maze dimensions availible in global context
        mazeY = maze[0].length;
        Stack<int[]> path =  new Stack<int[]>();   //stack to store the path
        path.push(firstPos); //put the starting point in the stack
        while(notDone){
            //algorithm as described in assignment
            //inBounds prevents index out of bounds errors
            if( inBounds(xPos,yPos+1)&&(maze[xPos][yPos + 1].equals(".")||maze[xPos][yPos + 1].equals("$"))){
                maze[xPos][yPos] = "x"; //covers up trail
                xPos = xPos;
                yPos = yPos + 1;
                int[] thePos = {xPos,yPos}; //array is initialized in this scope to ensure each coord get a unique memory address and isn't overwirtten
                path.push(thePos);
                if(maze[xPos][yPos].equals("$")){ //checks to see if it is at the solution
                    notDone = false;
                }
            }
            else if( inBounds(xPos,yPos-1)&&(maze[xPos][yPos-1].equals(".")||maze[xPos][yPos-1].equals("$"))){
                maze[xPos][yPos] = "x";
                xPos = xPos;
                yPos = yPos - 1;
                int[] thePos = {xPos,yPos};
                path.push(thePos);
                if(maze[xPos][yPos].equals("$")){
                    notDone = false;
                }
            }
            else if(inBounds(xPos-1,yPos)&&(maze[xPos - 1][yPos].equals(".")||maze[xPos - 1][yPos].equals("$"))){
                maze[xPos][yPos] = "x";
                xPos = xPos - 1;
                yPos = yPos;
                int[] thePos = {xPos,yPos};
                path.push(thePos);
                if(maze[xPos][yPos].equals("$")){
                    notDone = false;
                }
            }
            else if(inBounds(xPos+1,yPos)&&(maze[xPos + 1][yPos].equals(".")||maze[xPos + 1][yPos].equals("$"))){
                maze[xPos][yPos] = "x";
                xPos = xPos + 1;
                yPos = yPos;
                int[] thePos = {xPos,yPos};
                path.push(thePos);
                if(maze[xPos][yPos].equals("$")){
                    notDone = false;
                }
            }
            else{
                path.pop();
            }
        }
        //Need to flip the stack to have it print as described in the assignment
        Stack<int[]> printPath =  new Stack<int[]>();
        while(path.peek() != null){
            int[] value = path.pop();
            printPath.push(value);
        }
        System.out.println("Solution:");
        while(printPath.peek() != null){
            int[]value = printPath.pop();
            System.out.println(value[1] +","+ value[0]);
        }
    }

    /**
     * To turn the board into an array for traversal
     * @param none
     * @return String[][]: Array of maze characters
     */
    public static String[][] makeArray(){
        String[][] placeholder = new String[1][1];
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            String firstLine = scan.nextLine();
            int arrayWidth = firstLine.length();
            int arrayHeight = 0;
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));
            while(scan.hasNextLine()){
                String throwaway = scan.nextLine();
                arrayHeight++;
            }
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
            }
            placeholder = maze;
            return maze;
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
        return placeholder;
    }

    /**
     * to make sure checked spots are inBounds of the array
     * @param xPos: x position being checked
     * @param yPos: y position being checked
     * @return boolean: true if okay, false if outside array boundaries
     */
    public static boolean inBounds(int xPos, int yPos){
        if(yPos>= 0 && yPos < mazeY && xPos >= 0 && xPos <mazeX){
            return true;
        } else {
            return false;
        }
    }
}
