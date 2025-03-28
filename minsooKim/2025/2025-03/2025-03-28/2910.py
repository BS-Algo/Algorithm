N, C = map(int, input().split())
arr = list(map(int, input().split()))
dic = {}
for i in range(N):
    if arr[i] not in dic:
        dic[arr[i]] = 1
    else:
        dic[arr[i]] += 1

dic = sorted(dic.items(), key=lambda x:-x[1])

for i in range(len(dic)):
    for j in range(dic[i][1]):
        print(dic[i][0], end = " ")