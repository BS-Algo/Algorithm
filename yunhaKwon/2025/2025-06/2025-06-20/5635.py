n = int(input())

arr = []

for _ in range(n):
    name, dd, mm, yyyy = input().split()
    dd = int(dd)
    mm = int(mm)
    yyyy = int(yyyy)
    arr.append([yyyy, mm, dd, name])

arr.sort(reverse=True) #내림차순 정렬 (나이 어린 애부터~)

print(arr[0][3])
print(arr[-1][3])
