m = int(input())
n = int(input())
print([2*m + 2*n - 4, m * n][m <= 2 or n <= 2])