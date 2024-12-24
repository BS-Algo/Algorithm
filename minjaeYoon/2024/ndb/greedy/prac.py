def bignum(arr, data):
    n, m, k = arr
    data.sort()
    first = data[n-1]
    second = data[n-2]
    result = 0
    while True:
        for i in range(k):
            if m == 0:
                break
            result += first
            m -= 1
        if m == 0:
            break 
        result += second
        m -= 1
    return result
arr = [5, 8, 3]
data = [2, 4, 5, 4, 6]
print(bignum(arr, data))
