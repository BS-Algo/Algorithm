def card(arr, num):
    n, m = arr
    result = 0
    for i in range(n):
        min_num = min(num[i])
        result = max(result, min_num)
    return result

arr = [3, 3]
num = [
    [3, 1, 2],
    [4, 1, 4],
    [2, 2, 2]
]
print(card(arr, num))