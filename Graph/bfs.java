import java.util.*;

class Graph {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    Graph(int V) {

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {

        adj.get(u).add(v);
        adj.get(v).add(u); // Adding both because undirected graph

    }

  
    void bfs(int node,boolean[]visited)
    {
        
    }

}

public class bfs {
    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        // graph.printGraph();

        boolean[] visited = new boolean[5];

        graph.bfs(0, visited);

    }

}