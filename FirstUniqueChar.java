import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        // HashMap to count the frequency of each character
        HashMap<Character, Integer> count = new HashMap<>();

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            // If the character appears only once, return its index
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If there are no unique characters, return -1
        return -1;
    }
}
