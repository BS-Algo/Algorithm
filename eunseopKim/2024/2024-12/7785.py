import sys
input = sys.stdin.readline

n = int(input().rstrip())
company = {}
for _ in range(n):
    name, record = map(str, input().split())
    if record == 'enter' and name not in company:
        company[name] = name
    if record == 'leave' and name in company:
        company.pop(name)
companylist = list(company.values())
companylist.sort(reverse=True)
for i in companylist:
    print(i)
# 그냥 딕셔너리에서 정렬해도 된다