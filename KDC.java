package Test;

import java.util.HashMap;
import java.util.Map;

public class KDC {
    public static int lstr(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) {
            return 0;
        }

        int n = s.length();
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            while (count.size() > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                if (count.get(leftChar) == 0) {
                    count.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int result = lstr(s, k);
        System.out.println("Longest substring length: " + result);
    }
}
