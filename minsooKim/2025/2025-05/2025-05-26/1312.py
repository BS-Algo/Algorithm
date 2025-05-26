A, B, N = map(int, input().split())

# 25 7 5
# 25 % 7 = 몫 3, 나머지 4
# 3.571428
for _ in range(N):
    A = A * 10
    ans = A // B 
    A = A % B
print(ans)