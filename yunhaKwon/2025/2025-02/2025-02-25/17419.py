n = int(input())
k = input()
cnt = 0
for i in range(n):
    if k[i] == '1':
        cnt += 1
print(cnt)