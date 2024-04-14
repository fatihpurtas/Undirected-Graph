import java.util.*;
public class Graph {
    //-----------------------------------------------------------------
    // Title: Graph Class
    // Author: Fatih Purtaş
    // Section: 2
    // Assignment: 1
    // Description: Represents a structure for modeling connections
    //              (islands) and finding paths between them.
    //-----------------------------------------------------------------

    public final int V; // The graph's total vertex number.
    public int sizeOfGraph; // The size of the graph, representing the number of edges.
    public ArrayList<Integer>[] adj; // Adjacency lists for each vertex are stored in an array of ArrayLists.


    public void addEdge(int v, int w) {
        //-------------------------------------------------------
        // Summary:         Adds an undirected edge between vertices
        //                  'v' and 'w' to the graph.
        // Precondition:    'v' and 'w' should be valid vertex indices
        //                   within the graph (1 to V).
        //                   The graph (represented by the 'adj' array)
        //                   must be initialized with an appropriate size.
        // Postcondition:    An undirected edge is added between vertices 'v' and 'w'.
        //                   The 'sizeOfGraph' variable is incremented to reflect the
        //                   new edge.
        //-------------------------------------------------------
        adj[v-1].add(w);
        adj[w-1].add(v);
        sizeOfGraph++;
    }

    // Constructor to initialize the number of vertices to be used in the Graph object.
    public Graph(int V) {

        this.V = V;
        sizeOfGraph = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<Integer>();
    }
    public String depthfirstSearch(int startP, int endP) {
        //-------------------------------------------------------
        // Summary:       Performs a Depth First Search on the graph to find a
        //                path from the starting point to the ending point.
        // Precondition:  The graph object (represented by the 'adj' variable)
        //                must be properly initialized with vertices and edges.
        //                'startP' and 'endP' should be valid vertex indices within
        //                the graph (0 to V-1).
        // Postcondition: Returns a string representing the path from 'startP' to 'endP'
        //                if a path exists, otherwise returns an empty string.
        //-------------------------------------------------------



        ArrayList<Integer> path = new ArrayList<>(); // An ArrayList to store the path between start point and end point

        boolean[] visited = new boolean[V]; // Array to track visited vertices

        Stack<Integer> stack = new Stack<>(); // A Stack to facilitate depth first traversal



        // Push the beginning point into the stack after designating it as visited.
        visited[startP-1] = true;
        stack.push(startP);



        //When there are vertices in the stack, continue on traversing the graph.
        while (!stack.empty()) {
            startP = stack.peek(); // Get the top vertex from the stack



            // If the current point is the end point, build and return the path
            if(startP == endP) {
                path.add(startP);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    sb.append(path.get(i)).append(" ");
                }
                return sb.toString().trim();
            }



            // Obtain the current vertex's adjacency list and arrange it in ascending order.
            ArrayList<Integer> adjList = adj[startP-1];
            Collections.sort(adjList);
            boolean foundUnvisited = false;




            // Cycle through the current vertex's adjacent vertices.
            for (int i = 0; i < adjList.size(); i++) {
                int n = adjList.get(i);
                // If the adjacent vertex has not been visited, mark it as visited, push it onto the stack, and add it to the path
                if (!visited[n-1]) {
                    visited[n-1] = true;
                    stack.push(n);
                    path.add(startP);
                    foundUnvisited = true;
                    break;
                }
            }



            // Remove the current vertex from the path and pop it from the stack if there are no unvisited adjacent vertices discovered.
            if (!foundUnvisited) {
                stack.pop();
                if (!path.isEmpty()) {
                    path.remove(path.size() - 1);
                }
            }
        }
        return "";
    }
}