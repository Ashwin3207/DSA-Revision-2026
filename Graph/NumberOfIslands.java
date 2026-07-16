public class NumberOfIslands {

    public static int numIslands(char[][] grid,boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;
        int count= 0 ; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(grid[i][j]=='1' && !visited[i][j])
                {
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int i, int j, boolean visited[][], char[][] grid) {
        
        if(i<0 || i>=grid.length
            || j<0 || j>=grid[0].length
            || visited[i][j] 
            || grid[i][j] == '0'
        )
        {
            return;
        }
        
        visited[i][j] = true; // current visited;

        // visiting neighbors

        dfs(i - 1, j, visited, grid); // up
        dfs(i + 1, j, visited, grid); // down
        dfs(i, j - 1, visited, grid); // left
        dfs(i, j + 1, visited, grid); // right



    }

    public static void main(String[] args) {

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        System.out.println(numIslands(grid,visited));
    }
}