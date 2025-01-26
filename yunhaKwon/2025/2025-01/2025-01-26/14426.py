import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S_arr = sorted([input().strip() for _ in range(N)])
check = [input().strip() for _ in range(M)]

cnt = 0
for c in check:
    start = 0
    end = len(S_arr) - 1

    while start <= end:
        mid = (start + end) // 2
        if S_arr[mid].startswith(c): #startswith 이런게 있었다묘? 하.. 이거 모르면 못 풀묘? 어렵묘;;
            cnt += 1
            break
        elif S_arr[mid] < c:
            start = mid + 1
        else:
            end = mid - 1

print(cnt)