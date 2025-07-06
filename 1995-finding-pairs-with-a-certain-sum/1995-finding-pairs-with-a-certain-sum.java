class FindSumPairs {
    public int[] num1, num2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        num1 = nums1;
        num2 = nums2;
        for (int n : num2)
            map.put(n, map.getOrDefault(n, 0) + 1);
    }

    public void add(int index, int val) {
        map.put(num2[index], map.get(num2[index]) - 1);
        num2[index] += val;
        map.put(num2[index], map.getOrDefault(num2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int n : num1)
            count += map.getOrDefault(tot - n, 0);
        return count;
    }
}