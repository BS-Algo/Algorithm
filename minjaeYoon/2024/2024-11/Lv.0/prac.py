def solution(a, b):
    answer = int(max(f'{a}{b}', f'{2*a*b}'))
    if int(f'{a}{b}'==f'{2*a*b}'):
        answer = int(f'{a}{b}')
    return answer
print(solution(2, 91))