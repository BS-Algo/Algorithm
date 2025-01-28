def search_start(target):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2
        if dots[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return start

def search_end(target):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2
        if dots[mid] <= target:
            start = mid + 1
        else:
            end = mid - 1
    return start

N, M = map(int, input().split())
dots = list(map(int, input().split()))
lines = [list(map(int, input().split())) for _ in range(M)]

dots.sort()

for l in lines:
    s, e = l
    s_idx = search_start(s)
    e_idx = search_end(e)

    print(e_idx - s_idx)
