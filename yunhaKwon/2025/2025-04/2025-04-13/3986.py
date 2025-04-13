n = int(input())
res = 0

for _ in range(n):
    arr = []
    words = list(input())
    for word in words:
        if len(arr) == 0:
            arr.append(word)
        elif arr[-1] == word:
            arr.pop(-1)
        else:
            arr.append(word)

    if len(arr) == 0:
        res += 1

print(res)