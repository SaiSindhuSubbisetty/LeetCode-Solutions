import java.util.*;
class Solution{
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d)
    {
        int count = 0;
        Arrays.sort(arr2);
        for(int num:arr1)
        {
            int left = 0;
            int right = arr2.length-1;
            boolean isvalid = true;
            while(left <= right)
            {
                int mid = left + (right-left)/2;

                if(Math.abs(num-arr2[mid]) <= d)
                {
                    isvalid = false;
                    break;
                }

                if(arr2[mid] < num)
                {
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            if(isvalid)
            {
                count++;
            }
        }
        return count;

    }
}