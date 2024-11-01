package basics;
import java.util.Arrays;

public class ASCIIDecoder {

    /*
     * The 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["72", "101", "108", "108", "111"], ["87", "111", "114", "108", "100"]]
     * to your decode method, you should return : [ "Hello", "World" ].
     * 
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * Use the StringBuilder class and its method appendCodePoint(int) to translate the ASCII code.
     *
     * You should NEVER return null or an array containing null.
     */
    public static String[] decode(int[] forbidden, String[][] sentences){
        String[] result = new String[sentences.length];
        int index = 0;
        for (String[] sentence: sentences) {
            StringBuilder string_builder = new StringBuilder();
            for (String ascii_code: sentence) {
                int ascii = Integer.parseInt(ascii_code);
                if (forbidden != null && Arrays.stream(forbidden).anyMatch(i -> i == ascii)) {
                    continue;
                }
                string_builder.appendCodePoint(ascii);
            }
            result[index++] = string_builder.toString();
        }
        return result;
    }

}