class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        arr = []
        for i, row in enumerate(board[::-1]):
            arr.extend(row if i % 2 == 0 else row[::-1])
        ans = [0] + [float("inf")] * (len(arr) - 1)
        q = deque([0])
        while q:
            cur = q.popleft()
            if cur == len(arr) - 1:
                break
            for i in range(1, 7):
                if cur + i < len(arr):
                    nxt = cur + i if arr[cur + i] == -1 else arr[cur + i] - 1
                    if ans[nxt] > ans[cur] + 1:
                        q.append(nxt)
                        ans[nxt] = ans[cur] + 1
        return ans[-1] if ans[-1] != float("inf") else -1