package basics;

public class PatternMatching {

    /**
     * Look for one sequence of characters (the pattern) in an input
     * string, and return the position of the pattern in the string
     * (if present). If the pattern is present multiple times in the
     * string, the function must return the leftmost occurrence of the
     * pattern (i.e. the occurrence whose index is the lowest). The
     * function must be case-sensitive (i.e. <code>Hello</code> is not
     * the same as <code>hello</code>).
     * @param pattern The pattern to look for.
     * @param value The string to look in.
     * @result The index of the leftmost occurrence of the pattern in
     * the string. Must be <code>-1</code> if the pattern is absent
     * from the string.
     **/
    public static int find(String pattern, String value) {
        char[] patternChars = pattern.toCharArray();
        char[] valueChars = value.toCharArray();
        for (int index_in_value=0; index_in_value <= value.length() - pattern.length(); index_in_value++) {
            boolean found = true;
            for (int index_in_pattern=0; index_in_pattern < pattern.length(); index_in_pattern++){
                if (valueChars[index_in_value+index_in_pattern] != patternChars[index_in_pattern]){
                    found = false;
                    break;
                }
            }
            if (found) {
                return index_in_value;
            }
        }
        return -1;
    }

}
