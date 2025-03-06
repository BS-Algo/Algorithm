A, B, C = map(int, input().split())
D = int(input())

hour = 0
minute = 0
second = 0

if D < 3600:
    minute += D // 60
    second += D % 60

else:
    hour += D // 3600
    minute += (D % 3600) // 60
    second += (D % 3600) % 60

A = A + hour
B = B + minute
C = C + second

if C >= 60:
    B += C // 60
    C = C - 60

if B >= 60:
    A += B // 60
    B = B - 60
if A >= 24:
    A = A - 24

print(A, B, C)