N = int(input())
hansu = 0
for i in range(1, N + 1):
    num_lst = list(map(int, str(i)))
    if i < 100:
        hansu += 1
    elif num_lst[0] - num_lst[1] == num_lst[1]-num_lst[2]:
        hansu +=1
    print(num_lst)
print(hansu)
