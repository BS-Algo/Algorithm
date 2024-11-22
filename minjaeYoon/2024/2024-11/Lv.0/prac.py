def solution(a, b):
    if int(f'{a}{b}'==f'{2*a*b}'):
        return int(f'{a}{b}')
    return int(max(f'{a}{b}', f'{2*a*b}'))
print(solution(2, 91))