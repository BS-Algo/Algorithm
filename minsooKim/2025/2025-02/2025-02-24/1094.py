X = int(input())
bin_X = bin(X)
cnt = 0
for i in bin_X:
    if i == '1':
        cnt += 1
print(cnt)