package basics;

import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof QRcode) {
            QRcode other = (QRcode) o;
            for (int i = 0; i < 4; i++) {
                if (Arrays.deepEquals(this.data, other.data)) {
                    return true;
                }
                other = other.rotate();
            }
        }
        return false;
    }

    /**
     * Rotates the matrix by 90 degrees
     * @return a new QRcode object
     */
    public QRcode rotate() {
        int qr_size = data.length;
        boolean[][] result = new boolean[qr_size][qr_size];
        for (int i = 0; i < qr_size; i++) {
            for (int j = 0; j < qr_size; j++) {
                result[j][qr_size-i-1] = data[i][j];
            }
        }
        return new QRcode(result);
    }



}
