class Solution:
    def maxPartitionsAfterOperations(self, s: str, k: int) -> int:
        n = len(s)
        
        # Convert characters to bitmasks
        set_bits = [1 << (ord(ch) - ord('a')) for ch in s]
        
        def make_prefix(bits):
            """Build prefix partition counts and masks"""
            prefix = [0]  # prefix[i] = partitions up to index i-1
            prefix_mask = [0]  # prefix_mask[i] = char mask of last partition
            mask = 0
            groups = 0
            
            for bit in bits:
                mask |= bit
                if mask.bit_count() > k:
                    groups += 1
                    mask = bit  # Start new partition
                prefix.append(groups)
                prefix_mask.append(mask)
            
            return prefix, prefix_mask
        
        # Build prefix and suffix arrays
        prefix, prefix_mask = make_prefix(set_bits)
        suffix, suffix_mask = make_prefix(set_bits[::-1])
        
        max_partitions = 0
        
        # Try changing each position
        for i in range(n):
            # Partitions before and after position i
            candidate = prefix[i] + suffix[-(i + 2)]
            
            # Masks of surrounding partitions
            left_mask = prefix_mask[i]
            right_mask = suffix_mask[-(i + 2)]
            combined_mask = left_mask | right_mask
            
            # Determine middle contribution based on scenarios
            if min(combined_mask.bit_count() + 1, 26) <= k:
                # Can merge both sides with new char
                candidate += 1
            elif (left_mask.bit_count() == k and 
                  right_mask.bit_count() == k and 
                  combined_mask.bit_count() < 26):
                # Both sides full, but can create new partition
                candidate += 3
            else:
                # Standard case: change creates 2 partitions
                candidate += 2
            
            max_partitions = max(max_partitions, candidate)
        
        return max_partitions