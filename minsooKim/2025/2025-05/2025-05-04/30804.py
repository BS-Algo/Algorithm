N = int(input())
arr = list(map(int, input().split()))

left = 0
cnt = {}
max_len = 0

for  right in range(N):
    current = arr[right]

    if current in cnt:
        cnt[current] += 1
    else:
        cnt[current] = 1

    while len(cnt) > 2:
        remove_fruit = arr[left]

        cnt[remove_fruit] -= 1

        if cnt[remove_fruit] == 0:
            del cnt[remove_fruit]
        
        left += 1
    max_len = max(max_len, right-left + 1)
print(max_len)