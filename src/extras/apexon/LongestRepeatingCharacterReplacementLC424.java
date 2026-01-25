package extras.apexon;

public class LongestRepeatingCharacterReplacementLC424 {

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // if we need to replace more than k characters, shrink window
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
