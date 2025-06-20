n = int(input())
lst = []
for _ in range(n):
    name, day, month, year = map(str, input().split())
    day = int(day)
    month = int(month)
    year = int(year)
    lst.append([year, month, day, name])

lst.sort(reverse=True)
print(lst)