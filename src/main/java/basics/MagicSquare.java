package basics;

public class MagicSquare {


    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    public static boolean isMagicSquare(int [][] matrix) {
        int size = matrix.length;

        int line_sum_should_be = 0;
        for (int value: matrix[0]) {
            line_sum_should_be += value;
        }

        int diagonal_1 = 0;
        int diagonal_2 = 0;
        int check_range = matrix[0][0]; // taking a number for the matrix
        // if all conditions are met but this number is repeated then it's not a magic square

        for (int i = 0; i < size; i++) {
            int row_sum = 0;
            int column_sum = 0;
            diagonal_1 += matrix[i][i];
            diagonal_2 += matrix[i][size-i-1];
            for (int j = 0; j < size; j++) {
                row_sum += matrix[i][j];
                column_sum += matrix[j][i];
                if (matrix[i][j] <=0 || matrix[i][j] == check_range && i+j != 0) {
                    return false; // the numbers can't be negative either
                }
            }
            if (row_sum != line_sum_should_be || column_sum != line_sum_should_be) {
                return false;
            }
        }

        return diagonal_1 == line_sum_should_be && diagonal_2 == line_sum_should_be;
    }
}
