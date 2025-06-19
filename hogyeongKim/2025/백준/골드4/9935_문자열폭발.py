base_string = list(input())
match_string = input()

n, m = len(base_string), len(match_string)

def find_bomb():
    global m
    stack = []
    
    for char in base_string:
        stack.append(char)
        check = False
        while len(stack) >= m and stack[-1] == match_string[-1]:
            check = True
            for i in range(m):
                if stack[-(m-i)] != match_string[i]:
                    check = False
                    break
            if check:
                for _ in range(m):
                    stack.pop()
            else:
                break
        
    return stack if stack else 'FRULA'
        
result = find_bomb()
print(''.join(result))
