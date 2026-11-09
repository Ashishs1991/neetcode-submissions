class Solution {
    private static class Node {
        Node[] next = new Node[10];
        boolean counted;
    }

    public int equalDigitFrequency(String s) {
        Node root = new Node();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] frequency = new int[10];
            int distinctDigits = 0;
            int maxFrequency = 0;
            Node node = root;

            for (int j = i; j < s.length(); j++) {
                int digit = s.charAt(j) - '0';

                if (frequency[digit] == 0) {
                    distinctDigits++;
                }
                frequency[digit]++;
                maxFrequency = Math.max(maxFrequency, frequency[digit]);

                if (node.next[digit] == null) {
                    node.next[digit] = new Node();
                }
                node = node.next[digit];

                int length = j - i + 1;
                if (maxFrequency * distinctDigits == length && !node.counted) {
                    node.counted = true;
                    result++;
                }
            }
        }

        return result;
    }
}