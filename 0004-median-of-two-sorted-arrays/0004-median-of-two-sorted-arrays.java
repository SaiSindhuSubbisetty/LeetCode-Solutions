class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int x  = nums1.length;
        int y  = nums2.length;

        int start = 0;
        int end = x;

        while(start <= end)
        {
            int partx = (start+end)/2;
            int party = (x+y+1)/2-partx;

            int xLeft = partx == 0 ? Integer.MIN_VALUE:nums1[partx-1];
            int xRight = partx == x? Integer.MAX_VALUE:nums1[partx];
            int yLeft = party == 0? Integer.MIN_VALUE:nums2[party-1];
            int yRight = party == y?Integer.MAX_VALUE:nums2[party];

            if(xLeft <= yRight && yLeft <= xRight){
                if((x+y)%2 == 0)
                {
                    return ((double) Math.max(xLeft,yLeft) + Math.min(xRight,yRight))/2;
                }
                else{
                    return Math.max(xLeft,yLeft);
                }
            }
            if(xLeft > yRight)
            {
                end = partx-1;

            }
            else{
                start = partx+1;
            }
        }
        return 0;
        
    
    }
}