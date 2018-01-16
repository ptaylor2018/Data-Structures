
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

    }

    public int[][] readFile(){
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("graph.txt")));
            int graphSize = scan.nextInt();
            int[][] graph = new int[graphSize][graphSize];
            for(int i = 0; i < graphSize; i++){
                for(int j = 0; j < graphSize; j++){
                    graph[i][j]= scan.nextInt();
                }
            }
            System.out.println("File Read!");
            return graph;
        }catch (Exception e) { 
            System.out.println("WAT: " + e.getMessage());
        }
    }
}
