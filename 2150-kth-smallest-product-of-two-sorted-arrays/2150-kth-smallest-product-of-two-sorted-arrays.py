class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        min_product = min(nums1[0] * nums2[-1], nums1[-1] * nums2[0], 
                         nums1[0] * nums2[0], nums1[-1] * nums2[-1])
        max_product = max(nums1[0] * nums2[-1], nums1[-1] * nums2[0],
                         nums1[0] * nums2[0], nums1[-1] * nums2[-1]) + 1
        negatives1 = [n for n in nums1 if n < 0]
        positives1 = [n for n in nums1 if n > 0]
        zero_count1 = sum(1 for n in nums1 if n == 0)        
        negatives2 = [n for n in nums2 if n < 0]
        positives2 = [n for n in nums2 if n > 0]
        zero_count2 = sum(1 for n in nums2 if n == 0)
        return binary_search_leftmost(min_product, max_product, 
                                    lambda product: count_products_leq(product, 
                                                                      negatives1, positives1, zero_count1,
                                                                      negatives2, positives2, zero_count2) >= k)
def count_products_leq(target_product, negatives1, positives1, zero_count1, negatives2, positives2, zero_count2):
    count = 0    
    if target_product < 0:
        count += count_pairs_leq(target_product, negatives1, positives2[::-1])
        count += count_pairs_leq(target_product, positives1[::-1], negatives2)        
    else:
        count += len(negatives1) * len(positives2) + len(positives1) * len(negatives2)
        count += zero_count1 * (len(negatives2) + len(positives2))
        count += zero_count2 * (len(negatives1) + len(positives1))
        count += zero_count1 * zero_count2
        if target_product > 0:
            count += count_pairs_leq(target_product, negatives1[::-1], negatives2[::-1])
            count += count_pairs_leq(target_product, positives1, positives2)            
    return count
def count_pairs_leq(target_product, arr1, arr2):
    pair_count = 0
    right_ptr = len(arr2) - 1    
    for num in arr1:
        while right_ptr >= 0 and arr2[right_ptr] * num > target_product:
            right_ptr -= 1
        pair_count += right_ptr + 1    
    return pair_count
def binary_search_leftmost(low, high_exclusive, predicate):
    while low < high_exclusive:
        mid = (low + high_exclusive) // 2
        if predicate(mid):
            high_exclusive = mid
        else:
            low = mid + 1
    return high_exclusive