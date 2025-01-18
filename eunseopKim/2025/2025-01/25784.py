num=list(map(int, input().split()))
num.sort()

if num[0]+num[1]==num[-1]:
    print(1)
elif num[0]*num[1]==num[-1]:
    print(2)
else:
    print(3)