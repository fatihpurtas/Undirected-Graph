import java.util.Scanner;

public class Main {
    static int island,bi_boatroads, stateTime, travelTime, startP, endP;
    public static void main(String [] args) {
        //-----------------------------------------------------------------
        // Title: Main Class
        // Author: Fatih Purtaş
        // Assignment: 1
        // Description: This is the main class for Homework1 Question1 which
        //              calls the methods that perform the needed operations,
        //              which are intended to find and calculate the total
        //              time through the path from island X to island Y.
        //-----------------------------------------------------------------

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Graph graph = scanInfo(); // Read graph information and create a graph object

        String path = graph.depthfirstSearch(startP, endP); // Find the shortest path from the starting island (startP) to the ending island (endP) using Depth-First Search
        Printer printer = new Printer();
        printer.printer(path);
    }

    private static Graph scanInfo() {
        //-------------------------------------------------------
        // Summary: Reads user input and creates a graph object representing the island connections.
        // Precondition: None.
        // Postcondition: Creates a Graph object with 'island' vertices and adds edges based on 'bi_boatroads' connections.
        //               Additionally, stores starting and ending island points in 'startP' and 'endP' variables.
        //-------------------------------------------------------
        Scanner scan = new Scanner(System.in);

        island = scan.nextInt();
        bi_boatroads = scan.nextInt();
        stateTime = scan.nextInt();
        travelTime = scan.nextInt();

        Graph graphObj = new Graph(island); // This line of code creates a new instance of the Graph class, passing the number of island as a parameter.

        for(int i = 0; i < bi_boatroads; i++) {
            int forV = scan.nextInt();
            int forW = scan.nextInt();
            graphObj.addEdge(forV, forW); // This statement adds a connection (edge) between the vertices "forV" and "forW" in the graph.
        }

        startP = scan.nextInt();
        endP = scan.nextInt();
        scan.close();
        return graphObj; // This returns the graph object.
    }

    public static int timeCalc(String [] pathArray) {
        //-------------------------------------------------------
        // Summary: Calculates the total travel time for the given path.
        // Precondition: The 'pathArray' should represent a valid sequence of island names found by the pathfinding algorithm.
        //               'stateTime' and 'travelTime' variables should be initialized with valid values representing waiting and travel times respectively.
        // Postcondition: Returns the total travel time in minutes, considering both travel time and waiting periods between islands.
        //-------------------------------------------------------
        int timer = 0;
        int isWaiting;

        for (int i = 1; i < pathArray.length; i++) {
            isWaiting = timer % (2 * stateTime); // Current position within the state cycle (travel or wait)
            timer += travelTime; // This line of code simply increments the timer variable by the value of travelTime.

            // Check if waiting is necessary given the present state cycle position
            if(isWaiting > stateTime)
                // Calculate the waiting period by using the cycle's remaining duration.
                timer += stateTime*2 - isWaiting;// To account for waiting, adjust the timer by adding the amount of time left in the cycle (stateTime * 2) minus the position that the timer is currently in (isWaiting).
        }
        return timer;
    }



}