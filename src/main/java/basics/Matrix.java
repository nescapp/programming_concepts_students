package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] rows = s.split("\n");
        int[][] result = new int[rows.length][];
        int row_index = 0;
        for (String row: rows) {
             String[] elements = row.split(" ");
             result[row_index] = new int[elements.length];
             int element_index = 0;
             for (String element: elements) {
                 result[row_index][element_index] = Integer.parseInt(element);
                 element_index++;
             }
             row_index++;
         }
         return result;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int result = 0;
        for (int i = matrix.length-1; i>=0; i--) {
            for (int element: matrix[i]) {
                 result+=element;
            }
        }
        return result;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
         int number_of_rows = matrix.length;
         int lenght_of_rows = matrix[0].length;
         int[][] result = new int[lenght_of_rows][number_of_rows];
         for (int i = 0; i<lenght_of_rows; i++) {
             for (int j = 0; j<number_of_rows; j++) {
                 result[i][j] = matrix[j][i];
             }
         }
         return result;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
         int[][] result = new int[matrix1.length][matrix2[0].length];

         for (int i = 0; i<matrix1.length; i++) {
             for (int j = 0; j<matrix2[0].length; j++) {
                 for (int k = 0; k<matrix1[0].length; k++) {
                     result[i][j] += matrix1[i][k] * matrix2[k][j];
                 }
             }
         }
         return result;
    }
}