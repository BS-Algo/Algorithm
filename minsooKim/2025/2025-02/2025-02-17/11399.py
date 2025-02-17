N = int(input())
p = list(map(int, input().split()))
time = list(zip(range(1, N + 1), p))
time.sort(key=lambda x:x[1])
cnt = time[0][1]
lst = [time[0][1]]
for i in range(1, N):
    cnt += time[i][1]
    lst.append(cnt)
print(sum(lst))