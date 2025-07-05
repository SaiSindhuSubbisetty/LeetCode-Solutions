class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        n = len(operations)
        lengths = [1] * (n + 1)

        # Precompute the length after each operation
        for i in range(n):
            lengths[i + 1] = lengths[i] * 2

        shift = 0
        pos = k

        # Backtrack from the last operation
        for i in range(n, 0, -1):
            if pos <= lengths[i - 1]:
                # Still in the first half → nothing changes
                continue
            else:
                if operations[i - 1] == 0:
                    # If duplicated → map to first half
                    pos -= lengths[i - 1]
                else:
                    # If shifted → map to shifted half
                    pos -= lengths[i - 1]
                    shift += 1

        # After backtracking, it always maps to 'a'
        ans_ord = ord('a') + shift
        ans_char = chr(((ans_ord - ord('a')) % 26) + ord('a'))
        return ans_char
