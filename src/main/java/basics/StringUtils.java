package basics;

import javax.swing.text.Style;
import java.util.Arrays;

public class StringUtils {


    /**;
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        String[] result = new String[0];
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == delimiter) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = str.substring(start, i);
                start = i + 1;
            }
        }
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = str.substring(start);
        return result;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        if (str.contains(sub)) {
            return str.indexOf(sub);
        }
         return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
         for (char c: str.toCharArray()){
            if (Character.isUpperCase(c)){
                str = str.replace(c, Character.toLowerCase(c));
            }
         }
         return str;
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        int end = str.length()-1;
        for (int start=0;start!=end;start++) {
            if (str.charAt(start)!=str.charAt(end-start)) {
                return false;
            }
        }

         return true;
    }


}