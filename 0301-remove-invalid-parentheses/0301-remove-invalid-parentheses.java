import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check if current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If valid strings are found at this level,
            // don't remove more parentheses.
            if (found) {
                continue;
            }

            // Try removing one parenthesis
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // Don't remove letters
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next =
                    current.substring(0, i)
                    + current.substring(i + 1);

                // Avoid processing same string again
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }


    // Check whether parentheses are valid
    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;

                // Closing bracket came before opening bracket
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}