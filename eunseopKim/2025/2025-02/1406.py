import sys

arr1 = list(sys.stdin.readline().strip())
arr2 = []

n = int(input())
for _ in range(n):
    line = list(sys.stdin.readline().strip().split())
    if line[0] == 'L' and arr1:
        arr2.append(arr1.pop())
    elif line[0] == 'D' and arr2:
        arr1.append(arr2.pop())
    elif line[0] == 'B' and arr1:
        arr1.pop()
    elif line[0] == 'P':
        arr1.append(line[1])

print(''.join(arr1 + arr2[::-1]))