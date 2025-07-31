from collections import defaultdict
import sys
from math import ceil as ceil
input = sys.stdin.readline

students = {0:defaultdict(int), 1:defaultdict(int)}

n, k = map(int, input().split())

for _ in range(n):
    sex, grade = map(int, input().split())
    students[sex][grade] += 1

result = 0
result += ceil((students[0][1] + students[0][2] + students[1][1] + students[1][2]) / k)
for i in range(2):
    for j in range(3, 7, 2):
            result += ceil((students[i][j] + students[i][j+1]) / k)

print(result)