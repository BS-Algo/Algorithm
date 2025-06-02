S = input()
T = input()

def solve(S, T):
    if S == T:
        return True

    if solve(S + 'A', T):
        return 1

    if solve(S[::-1] + 'B', T):
        return 1

    else:
        return 0

print(solve(S, T))