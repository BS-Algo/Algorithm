n = int(input())
k = int(input())
num_lst = []

# 인덱스는 1 x 1에서 n x n까지 존재 = n x n개만큼의 인덱스가 존재.
start, end = 1, n*n

result = 0
# start가 end보다 작거나 같을 때까지 진행
while start <= end:
    # mid는 (start+end) // 2일 때, 1, 2, 3, ..., n개의 행이 존재
    # i번째 행에서 mid보다 작거나 같은 값의 개수는 i*j<=mid을 만족하는 경우 → j <= mid/i
    # 단 j는 최대 n까지만 가능하므로 min(mid//i, n)이 됨.
    mid = (start+end) // 2
    cnt = 0
    
    for i in range(1, n+1):
        cnt += min(mid // i, n)
        
    # 이 cnt 값이 k값과 같다면 그 값이 정답. 만약 cnt 값이 k값 보다 작다면, k번째 값을 찾는데 개수가 부족하므로 mid를 늘려서 재탐색.
    if cnt >= k:
        # 정확히 cnt == k값과 일치하지 않을 경우, cnt > k일 때 가장 작은 값이 되어야 함.
        result = mid
        end = mid - 1
    elif cnt < k:
        start = mid + 1
print(result)