import sys
input = sys.stdin.readline

n, r, c = map(int, input().split())

def solve(n, a, b):
    if n == 0:
        return 0
    else:
        # a % 2는 현재 행 좌표 a가 짝수인지 홀수인지를 판단
        # b % 2는 현재 열 좌표 b가 짝수인지 홀수인지를 판단
        # (2 * (a % 2) + (b % 2))를 통해 2×2 내부에서 (r, c)가 몇 번째 위치인지 구할 수 있다.
        return (2 * (a % 2) + (b % 2)) + (4 * solve(n - 1, (a // 2), (b // 2)))
    
print(solve(n, r, c))