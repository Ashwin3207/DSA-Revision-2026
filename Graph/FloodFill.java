public class FloodFill {

    public static int[][] floodFill(int[][] image,
            int sr,
            int sc,
            int newColor) {


    if (image[sr][sc] == newColor) {
        return image;
    }

        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    public static void dfs(int[][] image,

            int row,
            int col,
            int originalColor,
            int newColor) {

        if (row < 0 ||
                col < 0 ||
                row >= image.length
                || col >= image[0].length
                ||

                image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image,  row - 1, col, originalColor, newColor);
        dfs(image,  row + 1, col, originalColor, newColor);
        dfs(image,  row, col - 1, originalColor, newColor);
        dfs(image,  row, col + 1, originalColor, newColor);

    }

    public static void print(int[][] image) {

        for (int[] row : image) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        floodFill(image, 1, 1, 2);

        print(image);
    }
}