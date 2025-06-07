# 다항식 더하기
def solution(polynomial):
    answer = ''
    polynomial = [x for x in polynomial.split() if x != '+']
    vars, cons = 0, 0
    
    # 공백, 더하기, x
    for poly in polynomial:
        if 'x' in poly:
            new_poly = poly.replace('x', '')
            if new_poly == '':
                vars += 1
            else:
                vars += int(new_poly)
        elif poly.isdigit():
            cons += int(poly)
            
    if vars == 0 and cons == 0:
        return '0'
    elif vars == 0:
        return str(cons)
    elif cons == 0:
        if vars == 1:
            return 'x'
        else:
            return f'{vars}x'
    else:
        if vars == 1:
            return f'x + {cons}'
        else:
            return f'{vars}x + {cons}'
        
polynomial = "x + x + x"

print(solution(polynomial))