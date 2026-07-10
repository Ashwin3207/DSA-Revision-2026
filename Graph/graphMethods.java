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

    void printGraph() {

        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + " -> ");

            for (int neighbour : adj.get(i)) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }
}

public class graphMethods {
    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}