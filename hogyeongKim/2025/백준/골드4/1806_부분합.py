import sys
input = sys.stdin.readline

n, s = map(int, input().split())

numbers = list(map(int, input().split()))
mn_length = sys.maxsize
result = numbers[0]
left, right = 0, 0
while left <= right:
    if result < s:
        right += 1
        if right == n:
            break
        result += numbers[right]
    else:
        mn_length = min(mn_length, right + 1 - left)
        result -= numbers[left]
        left += 1
print(0 if mn_length == sys.maxsize else mn_length)