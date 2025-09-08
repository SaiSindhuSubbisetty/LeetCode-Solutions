class Solution 
{
    public int[] getNoZeroIntegers(int n) 
    {
        
        for(int a = 1;a<n;a++)
        {
            int b = n-a;
            if(isNonZero(a) && isNonZero(b))
            {
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
    public boolean isNonZero(int n)
    {
    while(n > 0)
    {
        if(n%10 == 0){
            return false;
        }
        n = n/10;
    }
    return true;
    }
}