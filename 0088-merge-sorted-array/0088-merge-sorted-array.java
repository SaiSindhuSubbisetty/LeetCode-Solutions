class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //3 pointers approach
        int p1 = m-1;
        int p2 = n-1;
        int p3 = nums1.length-1;
        while(p3 >= 0){
            int elem1,elem2;
            elem1 = (p1>=0)?nums1[p1]:Integer.MIN_VALUE;
            elem2 = (p2>=0)?nums2[p2]:Integer.MIN_VALUE;
            if(elem1 > elem2)
            {
                nums1[p3] = elem1;
                p1--;
            }
            else{
                nums1[p3] = elem2;
                p2--;
            }
            p3--;
        }
    }
}