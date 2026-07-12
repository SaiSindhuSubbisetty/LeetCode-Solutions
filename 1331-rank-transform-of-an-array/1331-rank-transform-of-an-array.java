class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[]{};
        if (arr.length == 1) return new int[]{1};

        int[][] temp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        int rank = 1;
        int prev = temp[0][0];
        for (int i = 0; i < arr.length; i++) {
            if (prev < temp[i][0]) rank++;
            arr[temp[i][1]] = rank;
            prev = temp[i][0];
        }

        return arr;
    }
}