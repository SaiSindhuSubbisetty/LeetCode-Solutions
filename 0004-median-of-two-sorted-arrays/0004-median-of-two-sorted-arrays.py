class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = nums1+nums2
        nums.sort()
        mid = len(nums)//2
        if len(nums)%2 == 0:
            return (nums[mid-1]+nums[mid])/2
        else:
            return nums[mid]    
                    