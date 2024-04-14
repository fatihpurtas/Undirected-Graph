import java.util.*;

public class Main {

    //-----------------------------------------------------------------
    // Title: Main Class
    // Author: Fatih Purtaş
    // Section: 2
    // Assignment: 1
    // Description:    This Main class reads user input to build a graph,
    //                 finds the shortest cycle with specific starting and ending points,
    //                 removes duplicates from the cycle, and prints the lexicographically smallest path.
    //-----------------------------------------------------------------

    static int city;
    static int bidirectional_path;
    static int mustP;
    static int startP;
    static ArrayList <Integer> cycle;

    public static void main(String[] args) {
        Graph graph = scanInfo(); // Scans input.
        cycle = graph.find_cycle(startP, mustP); //  Method call from the Graph class.
        cycle = distinct(cycle);    // Method call for get the distinct array list.

        if (!cycle.isEmpty()) {
            Collections.sort(cycle);    // Sorts the arraylist.

            System.out.print(cycle.get(0)); // Prints the lexicographcally smallest path.
            for (int i = 1; i < cycle.size(); i++)
                System.out.print(" " + cycle.get(i));
        }
    }
    private static <T> ArrayList<T> distinct(ArrayList <T> list) {
        HashSet<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
    private static Graph scanInfo() {

        //-------------------------------------------------------
        // Summary:         Reads information about a graph from user input and creates a Graph object.
        // Precondition:    User input should be valid integers representing the number of cities.
        //                  existence of bidirectional paths, and vertex indices for edges and
        //                  starting/ending points.
        // Postcondition:   Reads user input (start/end points) and builds a
        //                  Graph object representing the connections.
        //-------------------------------------------------------

        Scanner scan = new Scanner(System.in);

        city = scan.nextInt();
        bidirectional_path = scan.nextInt();

        Graph graph = new Graph(city); // By passing the number of cities as a parameter, this line of code generates a new instance of the Graph class.

        for(int i = 0; i < bidirectional_path; i++) {
            int forW = scan.nextInt();
            int forV = scan.nextInt();
            graph.add_edge(forV, forW); // With this statement, the graph's vertices "forV" and "forW" now have a link (edge).
        }

        startP = scan.nextInt();
        mustP = scan.nextInt();
        scan.close();
        return graph;
    }


}