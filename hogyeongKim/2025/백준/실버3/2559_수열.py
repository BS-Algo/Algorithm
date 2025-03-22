N, K = map(int, input().split())

num_lst = list(map(int, input().split()))

prefix = [0] * (N + 1)
result = []

for i in range(N):
    prefix[i + 1] = prefix[i] + num_lst[i]
    
for i in range(K, N+1):
    result.append(prefix[i] - prefix[i - K])

print(max(result))