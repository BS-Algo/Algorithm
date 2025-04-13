import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
m = int(input())
num_lst = list(map(int, input().split()))

qstack = deque([B[i] for i in range(n) if A[i] == 0])
result = []

for num in num_lst:
    qstack.appendleft(num)
    result.append(qstack.pop())

print(*result)