arr = [0] * 5
num = 0
num_i = 0
for i in range(5):
    arr[i] = sum(list(map(int, input().split())))
    if arr[i] > num:
        num = arr[i]
        num_i = i + 1
print(num_i, num)        


