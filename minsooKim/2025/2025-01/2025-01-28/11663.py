def search_start(a):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2
        
        if a > arr[mid]: # [1, 3, 10, 20, 30] 1 <= 10
            start = mid + 1
        else:
            end = mid - 1
    return end 

def search_end(b):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2
        
        if b >= arr[mid]:
            start = mid + 1
        else:
            end = mid -1
    return start

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
for _ in range(M):
    a, b = map(int, input().split())
    real_start = search_start(a)
    real_end = search_end(b)
    print( real_end - real_start - 1)

        


