N = int(input())
num = 1
for i in range(1, N+1):
    num *= i
num = str(num)
num = num[::-1]
print(num)
cnt = 0
for i in range(1, len(num)):
    if num[i-1] == '0' and num[i] != '0':
        cnt += i
        break
print(cnt)
