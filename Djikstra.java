import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Uses Djikstra's algorithm to find best path
 * 
 * @author Patrick Taylor 
 * @version 1.0.0
 */
public class Djikstra
{
    public static void main (String args[]){
        System.out.println("Welcome to Dijkstra Town");
        int[][] graph = readFile();
        printGraph(graph);
        Scanner user_input = new Scanner( System.in );
        boolean exit = false;
        String quit = "n";
        while(exit == false){
            System.out.print("Do you want to quit?(y/n): ");
            quit = user_input.next();
            if(quit.equals("n")){
                exit = false;
            }
            if(quit.equals("y")){
                exit = true;
            }
            if (exit == false){
                djikstra(graph);
            }
        }

    }

    /**
     * reads the file containing the graph, saves in 2d array
     * @return int[][]: array of graph
     */
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

    /**
     * actually runs the algorithm
     * @param int[][] graph: array containing graph
     * @return void
     */
    public static void djikstra(int[][] graph){
        //grather starting info
        Scanner user_input2 = new Scanner( System.in );
        int startingNode;
        System.out.print("Enter starting Node: ");
        startingNode = user_input2.nextInt();
        int endingNode;
        System.out.print("Enter ending Node: ");
        endingNode = user_input2.nextInt();
        user_input2.close();
        //initial setup of lists of unvisited/visited nodes, table, current node
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
        pathTable[startingNode][1] = -1;
        int currentNode = startingNode;
        //actual algorithm
        while(unvisitedNodes.size() > 0){
            //choose node with the smallest known value, set to current node
            int lowestVal = Integer.MAX_VALUE;
            int lowestNode = currentNode;
            for(int i = 0; i < unvisitedNodes.size(); i++){
                if(pathTable[unvisitedNodes.get(i)][0] < lowestVal){
                    lowestVal = pathTable[unvisitedNodes.get(i)][0];
                    lowestNode = unvisitedNodes.get(i);
                }
            }
            currentNode = lowestNode;
            //figue out distance for adjacent nodes
            for(int i = 0; i < graph.length; i++){
                if(graph[currentNode][i] != -1){
                    int distance = graph[currentNode][i] + pathTable[currentNode][0];
                    if(distance < pathTable[i][0]){
                        pathTable[i][0] = distance;
                        pathTable[i][1] = currentNode;
                    } 
                }
            }
            //move current node from list of visited nodes to list of unvisited nodes
            visitedNodes.add(currentNode);
            unvisitedNodes.remove(unvisitedNodes.indexOf(currentNode));
        }
        printTable(pathTable);
        //figrues out optimal path by backtracking through table, then prints it
        Stack<Integer> stack = new Stack<Integer>();
        int backTrackNode = endingNode;
        while(pathTable[backTrackNode][1] != -1){
            stack.push(backTrackNode);
            backTrackNode = pathTable[backTrackNode][1];
        }
        stack.push(startingNode);
        System.out.println("Best Path");
        while(stack.empty() != true){
            System.out.print(stack.pop() +" ");
        }
    }

    /**
     * prints out the graph array for checking
     * @param int[][] graph: array containing graph
     * @return void
     */
    public static void printGraph(int[][] graph){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println();
        }
    }

    /**
     * prints out table of distances and previous nodes for checking
     * @param int[][] table: table of values
     * @return void
     */
    public static void printTable(int[][] table){
        for(int i = 0; i <table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                System.out.print(table[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
