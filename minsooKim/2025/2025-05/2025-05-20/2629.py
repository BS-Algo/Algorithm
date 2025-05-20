p = int(input())
p_lst = list(map(int, input().split()))
bead = int(input())
bead_lst = list(map(int,input().split()))
dp = [0]

for w in p_lst:
    arr = []
    for i in dp:
        arr.append(i+w)
        arr.append(abs(i-w))

    dp = list(set(dp + arr))

for i in range(bead):
    if bead_lst[i] in dp:
        print("Y", end = " ")
    else:
        print("N")
        