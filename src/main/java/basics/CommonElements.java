package basics;

public class CommonElements {
    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {i such that tab1[i] == tab2[i]}
     *         for instance count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int [] tab1, int [] tab2) {
        int index = 0;
        int counter = 0;
        while (index < tab1.length && index < tab2.length) {
            if (tab1[index] == tab2[index]) {
                counter++;
            }
            index++;
        }
        return counter;
    }

    /**
     *
     * @param tab1 is a non null 2D array
     * @param tab2 is a non null 2D array
     * @return the number of elements that are the same at the same index
     *         more exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int count(int [][] tab1, int [][] tab2) {
        int indexX = 0;
        int counter = 0;

        while (indexX < tab1.length && indexX < tab2.length) {
            int indexY = 0;
            while (indexY < tab1[indexX].length && indexY < tab2[indexX].length) {
                if (tab1[indexX][indexY] == tab2[indexX][indexY]) {
                    counter++;
                }
                indexY++;
            }
            indexX++;
        }
        return counter;
    }
}
