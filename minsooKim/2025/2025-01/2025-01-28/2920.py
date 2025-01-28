lst = [1, 2, 3, 4, 5, 6, 7, 8]
arr = list(map(int, input().split()))
if lst == arr:
    print("ascending")
elif lst[::-1] == arr:
    print("descending")
else:
    print("mixed")

