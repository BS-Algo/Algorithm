def solution(a, b, flag):
    if bool(flag) == True:
        return int(f'{a+b}')
    elif bool(flag) == False:
        return int(f'{a-b}')


print(solution(-4, 7, True))
print(solution(-4, 7, False))