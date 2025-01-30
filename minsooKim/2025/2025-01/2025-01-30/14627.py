S, C = map(int, input().split())
arr = []
for _ in range(S):
    arr.append(int(input()))
start = 1
end = max(arr)
result = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in arr:
        cnt += i // mid
    if cnt < C:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
# result = 175가 나온상황.
# 440 - 175 - 175
print(result)
answer = 0
A = sum(arr) - (C * result)
print(A)