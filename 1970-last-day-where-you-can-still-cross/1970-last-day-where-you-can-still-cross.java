class Solution {
    private int[] stack = new int[10_000];

    public int latestDayToCross(int row, int col, int[][] cells) {
        boolean[] matrix = new boolean[row * col];

        int n = cells.length;

        int left = 0, right = n - 1;
        int state = 0;
        while (left < right) {
            int mid = right - (right - left) / 2;
            applyDiff(matrix, row, col, cells, state, mid);
            state = mid;
            if (hasPath(matrix, row, col)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    private void applyDiff(boolean[] matrix, int row, int col, int[][] cells, int from, int to) {
        boolean modify = from < to;
        int start = modify ? from : to + 1;
        int finish = modify ? to : from;
        for (int i = start; i <= finish; i++) {
            int[] cell = cells[i];
            matrix[(cell[0] - 1) * col + cell[1] - 1] = modify;
        }
    }

    private boolean hasPath(boolean[] matrix, int row, int col) {
        int length = matrix.length;
        boolean[] visited = Arrays.copyOf(matrix, length);

        int s = 0;
        for (int i = 0; i < col; i++) {
            if (!matrix[i]) {
                stack[s++] = i;
                visited[i] = true;
            }
        }

        while (s > 0) {
            int current = stack[--s];

            if (current / col == row - 1) {
                return true;
            }

            int down = current + col;
            int right = current + 1;
            int left = current - 1;
            int up = current - col;

            if (up >= 0 && !visited[up]) {
                stack[s++] = up;
                visited[up] = true;
            }

            if (current / col == right / col && !visited[right]) {
                stack[s++] = right;
                visited[right] = true;
            }

            if (left >= 0 && current / col == left / col && !visited[left]) {
                stack[s++] = left;
                visited[left] = true;
            }

            if (down < length && !visited[down]) {
                stack[s++] = down;
                visited[down] = true;
            }
        }

        return false;

    }
}