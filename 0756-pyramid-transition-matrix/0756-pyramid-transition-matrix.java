import java.util.*;

public class Solution {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Map to store pairs -> possible top blocks
        Map<String, List<Character>> map = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map) {
        // Base case: pyramid completed
        if (bottom.length() == 1) {
            return true;
        }

        // Try to build the next row
        return buildNextRow(bottom, 0, new StringBuilder(), map);
    }

    private boolean buildNextRow(String bottom, int index,
                                 StringBuilder nextRow,
                                 Map<String, List<Character>> map) {

        // If next row is fully built
        if (index == bottom.length() - 1) {
            return dfs(nextRow.toString(), map);
        }

        String pair = bottom.substring(index, index + 2);

        // If no allowed pattern for this pair
        if (!map.containsKey(pair)) {
            return false;
        }

        // Try all possible top blocks
        for (char ch : map.get(pair)) {
            nextRow.append(ch);
            if (buildNextRow(bottom, index + 1, nextRow, map)) {
                return true;
            }
            nextRow.deleteCharAt(nextRow.length() - 1); // backtrack
        }

        return false;
    }
}
