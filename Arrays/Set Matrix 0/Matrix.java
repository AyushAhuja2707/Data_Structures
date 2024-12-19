import java.util.Arrays;

class Matrix {

    static int[][] zeroMatrix(int[][] matrix, int n, int m) {
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }

            }
        }
        printMatrix(matrix);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 4, 3, 1, 5 }
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        printMatrix(ans);

    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
