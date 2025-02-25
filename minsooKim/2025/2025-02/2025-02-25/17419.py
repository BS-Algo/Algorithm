N = int(input())
K = input()
cnt = 0
for i in range(N):
    if K[i] == '1':
        cnt += 1
print(cnt)