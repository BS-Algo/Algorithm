N = int(input())
pizza = list(map(int, input().split()))
pizza_lst = []
for i in range(1, len(pizza)+1):
    pizza_lst.append([i, pizza[i-1]])
tmp = 0
tmp_lst = []
while pizza_lst:
    if pizza_lst[0][1] == 1:
        tmp += 1
        tmp_lst.append([pizza_lst[0][0], tmp])
        pizza_lst.pop(0)
    elif pizza_lst[0][1] != 1:
        tmp += 1
        pizza_lst[0][1] -= 1
        pizza_lst.append(pizza_lst[0])
        pizza_lst.pop(0)
sorted_data = sorted(tmp_lst, key=lambda x: x[0])
new_lst = []
for i in range(len(sorted_data)):
    new_lst.append(sorted_data[i][1])
print(*new_lst)


