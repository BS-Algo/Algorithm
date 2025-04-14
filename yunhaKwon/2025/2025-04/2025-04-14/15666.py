n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums = sorted(list(set(nums)))

ans = []
def dfs(idx, cnt):
    if cnt == m:
        print(' '.join(map(str, ans)))
        return

    for i in range(idx, len(nums)):
        ans.append(nums[i])
        dfs(i, cnt+1)
        ans.pop()

dfs(0, 0)