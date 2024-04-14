public class Printer {

    //-----------------------------------------------------------------
    // Title: Printer Class
    // Author: Fatih Purtaş
    // Section: 2
    // Assignment: 1
    // Description: This class processes the shortest path found by a
    //              pathfinding algorithm. It takes a string representing
    //              the island sequence and prints:Number of islands visited,
    //              full path string and total travel time (including waiting periods)
    //-----------------------------------------------------------------
    public static void printer (String path) {
        //-------------------------------------------------------
        // Summary: Prints information about the shortest path found.
        // Precondition: The 'path' string should represent a valid sequence of islands found by the pathfinding algorithm.
        // Postcondition: Prints the number of islands visited and the total travel time.
        //-------------------------------------------------------

        Main main = new Main(); // there is a timecalc function in the main class
        String [] pathArray = path.split(" "); // Split path string into an array of island names
        int numIsland = pathArray.length; // Calculate number of islands visited
        int travelTime = main.timeCalc(pathArray); // Calculate total time with waiting periods
        System.out.println(numIsland);
        System.out.println(path);
        System.out.println(travelTime);
    }
}
