package extras.apexon;

import java.util.Arrays;

public class StringCompression {

    public static int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currChar = chars[read];
            int count = 0;
            while (read < chars.length && currChar == chars[read]) {
                count++;
                read++;
            }

            chars[write++] = currChar;

            if (count > 1) {
                for (char c: String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        System.out.println(Arrays.toString(chars));

        return write;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'}));
    }
}
