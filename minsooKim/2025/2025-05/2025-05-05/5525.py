N = int(input())
M = int(input())
S = str(input())
real_num = N * 2 + 1
arr = ['IOI']
plus_oi = 'OI'
cnt = 0
if N == 1:
    for i in range(M):
        if arr == S[i:i+real_num]:
            cnt += 1
else:
    arr.append(plus_oi * (N-1))
    print(arr)
    for i in range(M):
        if arr == S[i:i+real_num]:
            cnt += 1
print(cnt)