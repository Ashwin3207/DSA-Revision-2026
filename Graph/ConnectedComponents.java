import java.util.*;

class Graph {

    ArrayList<ArrayList<Integer>> adj;
    int V;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Undirected graph
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS traversal for one connected component
   void dfs(boolean[]visited, int node)
   {
        visited[node]=true;

        for(int neighbour : adj.get(node))
        {if(!visited[neighbour])
            dfs(visited, neighbour);
        }
   }

    // YOU IMPLEMENT THIS
    int countComponents(boolean[]visited,int V) {

        int count=0;
        for(int i = 0 ; i< V ; i ++)
        {
            if(!visited[i])
            {
                dfs(visited, i);
                count++;
            }
        }

        return count;
    }
}

public class ConnectedComponents {

    public static void main(String[] args) {

        Graph graph = new Graph(6);

        // Component 1: 0 -- 1 -- 2
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        // Component 2: 3 -- 4
        graph.addEdge(3, 4);

        // Component 3: node 5 alone

        boolean[] visited = new boolean[6];
        System.out.println(graph.countComponents(visited,6));
    }
}