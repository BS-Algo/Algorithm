A, B = map(int, input().split())

A -= 1

cnt_A = A
cnt_B = B

for i in range(1, 99):
    tmp_A = (A//(2**i)) * (2**i - 2**(i-1))
    tmp_B = (B//(2**i)) * (2**i - 2**(i-1))
    cnt_A += tmp_A
    cnt_B += tmp_B
    if tmp_A == 0 and tmp_B == 0:
        break

print(cnt_B - cnt_A)