package learn.ds.dp;

public class MatrixChainMultiplication {
    private int[][] mat1;
    private int[][] mat2;
    private int[][] mat3;
    private int[][] mat4;
    private int[][] mat5;

    int[][] array;

    public MatrixChainMultiplication() {
        int[][] mat1 = new int[10][15];
        int[][] mat2 = new int[10][15];
        int[][] mat3 = new int[10][15];
        int[][] mat4 = new int[10][15];
        int[][] mat5 = new int[10][15];
        // int[][] mat1 = new int[10, 15];
        // int[][] mat1 = new int[10, 15];

        MatrixChainMultiplication m = new MatrixChainMultiplication(mat1, mat2, mat3, mat4, mat5);

    }

    public MatrixChainMultiplication(int[][] mat1, int[][] mat2, int[][] mat3, int[][] mat4, int[][] mat5) {
        this.mat1 = mat1;
        this.mat2 = mat2;
        this.mat3 = mat3;
        this.mat4 = mat4;
        this.mat5 = mat5;

        array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = 0;
            }
        }

        Perform();

    }

    private void Perform() {
        
        for (int i = 1; i < array[0].length; i++) {
            int start = 1;

            for (int j = i + 1; j < array[1].length; j++) {
                array[start][j] = Math.min(array[start][j - 1], array[start + 1][j]);
                start++;

            }
        }

    }
}