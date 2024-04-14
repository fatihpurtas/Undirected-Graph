import java.util.*;
public class Graph {

    //-----------------------------------------------------------------
    // Title: Graph Class
    // Author: Fatih Purtaş
    // Section: 2
    // Assignment: 1
    // Description: This Graph class represents undirected graphs,
    //              allowing creation, edge addition, and finding
    //              shortest cycles with specific starting and ending points.
    //-----------------------------------------------------------------

    public ArrayList<Integer>[] adj; // An array of ArrayLists to store the adjacency lists of each vertex.
    public final int V; // The number of vertices in the graph.
    public int graph_size; // The size of the graph, representing the number of edges.

    public Graph(int V) { // Constructor for initializing the Graph object with the specified number of vertices.
        this.V = V; // Set the number of vertices
        graph_size = 0; // Initialize the size of the graph to 0
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>(); // Initialize each adjacency list
    }

    public void add_edge(int v, int w) { // Method to add an edge between vertices v and w in the graph.

        //-------------------------------------------------------
        // Summary:         Adds an edge between two vertices in the graph (undirected).
        // Precondition:    'v' and 'w' should be valid vertex indices within the graph (1 to V).
        // Postcondition:   An edge is added between vertices 'v' and 'w' in the adjacency list
        //                  representation of the graph. The graph size ('graph_size') is incremented by 1.
        //-------------------------------------------------------

        adj[v-1].add(w);
        adj[w-1].add(v);
        graph_size++;
    }

    public ArrayList<Integer> find_cycle(int start_point, int must_point) {

        //-------------------------------------------------------
        // Summary:         Finds the shortest cycle in the graph that starts at `start_point`,
        //                  passes through 'must_point', and returns to 'start_point'.
        // Precondition:    The graph object ('adj' variable) must be properly initialized with
        //                  vertices and edges.
        //                  start_point` and 'must_point' should be valid vertex indices within
        //                  the graph (1 to V).
        // Postcondition:   Returns an ArrayList containing the shortest cycle found, including
        //                  'start_point', 'must_point', and other traversed vertices in the order
        //                  they were visited.
        //                  If no cycle is found or 'must_point' is not encountered,
        //                  an empty ArrayList is returned.
        //-------------------------------------------------------

        boolean[] visited = new boolean[this.V]; // An array to record vertices visited

        int[] distance = new int[this.V]; // Array to store the distance between each vertex and the start point

        Stack<Integer> stack = new Stack<>(); // Stack to store the vertices in the DFS traversal

        Arrays.fill(distance, -1); // Initialize all distances to -1

        ArrayList<Integer> cycle_path = new ArrayList<>(); // The current cycle path is stored in a list.

        ArrayList<Integer> shortest_cycle = new ArrayList<>(); // List to store the shortest discovered cycle

        int current_point;

        // Start the Depth First Search traversal from startPoint
        visited[start_point - 1] = true;
        distance[start_point - 1] = 0;
        stack.push(start_point);

        while (!stack.empty()) {
            current_point = stack.peek(); // Take the top element out of the stack without removing it

            ArrayList<Integer> adjList = this.adj[current_point - 1];  // Get and sort the adjacency list of the current vertex
            Collections.sort(adjList);
            boolean foundUnvisited = false;
            // Iterate through the adjacent vertices
            for (int i : adjList) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    distance[i - 1] = distance[current_point - 1] + 1;
                    stack.push(i);
                    cycle_path.add(current_point);
                    foundUnvisited = true;
                    break;
                }
                else if (i == start_point && cycle_path.size() >= 2 && (shortest_cycle.isEmpty() || distance[current_point - 1] + 1 < shortest_cycle.size())) {

                    // If the neighboring vertex is the start_point, the cycle path must have at least two vertices, and the current cycle is shorter than any previously discovered cycles.

                    cycle_path.add(current_point); // Add current vertex to the cycle_path
                    cycle_path.add(i); // Add the start_point to the cycle path

                    // If the cycle path includes the must_point, update the shortest_cycle.
                    if (cycle_path.contains(must_point))
                        shortest_cycle = new ArrayList<>(cycle_path);

                    // To backtrack, remove the last two added vertices from the cycle_path.
                    cycle_path.remove(cycle_path.size() - 1);
                    cycle_path.remove(cycle_path.size() - 1);
                }
            }
            // If no unvisited adjacent vertex is found, backtrack in the Depth First Search traversal
            if (!foundUnvisited) {
                stack.pop();
                if (!cycle_path.isEmpty()) {
                    cycle_path.remove(cycle_path.size() - 1);
                }
            }
        }
        return shortest_cycle;
    }
}