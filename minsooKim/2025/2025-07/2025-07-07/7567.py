arr = input()
num = 10
for i in range(1, len(arr)):
    if arr[i] == arr[i-1]:
        num += 5
    else:
        num += 10
print(num)