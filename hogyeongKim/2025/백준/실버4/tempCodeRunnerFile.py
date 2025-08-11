import sys
input = sys.stdin.readline

cnt = int(input())
switches = [0] + list(map(int, input().split()))
n = int(input())
students = [tuple(map(int, input().split())) for _ in range(n)]
for gender, number in students:
    if gender == 1:
        for i in range(number, cnt+1, number):
            switches[i] = 1 - switches[i]
    else:
        switches[number] = 1 - switches[number]
        left, right = number - 1, number + 1
        if left <= 1 or right >= cnt:
            continue
        while switches[left] == switches[right]:
            switches[left] = 1 - switches[left]
            switches[right] = 1 - switches[right]
            if left == 1 or right == cnt:
                break
            else:
                left -= 1
                right += 1

for i in range(1, cnt+1):
    if i > 1 and (i-1) % 20 == 0:
        print()
    print(switches[i], end=' ')