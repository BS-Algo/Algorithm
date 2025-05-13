import sys
from itertools import islice
# from collections import Counter
from collections import defaultdict

input = sys.stdin.readline

t = int(input().rstrip())

n = int(input().rstrip())
dp_a = [[] for _ in range(n)]
dp_a[0] = list(map(int, input().split()))

m = int(input().rstrip())
dp_b = [[] for _ in range(m)]
dp_b[0] = list(map(int, input().split()))

cnt = 0
if n > 1:
    for i in range(n-1):
        dp_a[1].append(dp_a[0][i]+dp_a[0][i+1])

if m > 1:
    for i in range(m-1):
        dp_b[1].append(dp_b[0][i]+dp_b[0][i+1])

for i in range(2, n):
    for j in range(n-i):
        dp_a[i].append(dp_a[i-1][j]+dp_a[i-1][j+1]-dp_a[i-2][j+1])
    
for i in range(2, m):
    for j in range(m-i):
        dp_b[i].append(dp_b[i-1][j]+dp_b[i-1][j+1]-dp_b[i-2][j+1])
        
result_a = [total for i in range(n) for total in dp_a[i]]
result_b = [total for i in range(m) for total in dp_b[i]]

count_dict = defaultdict(int)
for number_b in result_b:
    count_dict[number_b] += 1

for number_a in result_a:
    cnt += count_dict[t-number_a]
    
print(cnt)