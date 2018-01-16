import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class djikstra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Djikstra
{
    public static void main (String args[]){
        System.out.println("Welcome to Dijkstra Town");
        int[][] graph = readFile();
        int startingNode = 0;
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
        ArrayList<Integer> unvisitedNodes = new ArrayList<Integer>();
        for(int i = 0; i < graph.length; i++){
            unvisitedNodes.add(i);
        }
        int[][] pathTable = new int[graph.length][2];
        for(int i = 0; i < graph.length; i++){
            pathTable[i][0] = Integer.MAX_VALUE;
        }
        pathTable[startingNode][0] = 0;
        int currentNode = startingNode;
        while(unvisitedNodes.size() > 0{
            //choose node with the smallest known value
            int lowestVal = Integer.MAX_VALUE;
            int lowestNode = startingNode();
            for(int i = 0; i < unvisitedNodes.size(); i++){
                if(pathTable[unvisitedNodes[i]] < lowestVal){
                    lowestVal = pathTable[unvisitedNodes[i]];
                    lowestNode = unvisitedNodes[i];
                }
            }
            
        }
    }

    public static int[][] readFile(){
        int[][] graph = new int[1][1];
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("graph.txt")));
            int graphSize = scan.nextInt();
            graph = new int[graphSize][graphSize];
            for(int i = 0; i < graphSize; i++){
                for(int j = 0; j < graphSize; j++){
                    graph[i][j]= scan.nextInt();
                }
            }
            System.out.println("File Read!");

        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
        return graph;
    }
}
