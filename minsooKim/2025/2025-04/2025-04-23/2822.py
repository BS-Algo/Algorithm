N = 8
arr = []
for i in range(1, N+1):
    num = int(input())
    arr.append([num, i])
arr.sort()
lst = arr[3:]
real_lst = sorted(lst, key=lambda x:x[1])
sum_num = 0
realreal_lst = []
for i in range(5):
    sum_num += real_lst[i][0]    
    realreal_lst.append(real_lst[i][1])
print(sum_num)
print(*realreal_lst)




