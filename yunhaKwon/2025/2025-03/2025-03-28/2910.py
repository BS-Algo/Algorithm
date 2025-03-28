n, c = map(int, input().split())
lst = list(map(int, input().split()))

cnt_dic = {}
for i in lst:
    if i in cnt_dic:
        cnt_dic[i] += 1
    else:
        cnt_dic[i] = 1

cnt_dic = sorted(cnt_dic.items(), key=lambda x:x[1], reverse=True)

for key, val in cnt_dic:
    for _ in range(val):
        print(key, end=" ")