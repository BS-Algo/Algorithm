numbers = [0] * 10

n = int(input())

digits = 1
while digits <= n:
    portion = n // (digits*10)
    current = (n // digits) % 10
    rest = n % digits

    
    for i in range(1, 10):
        if i < current:
                numbers[i] += (portion + 1) * digits
        elif i == current:
            numbers[i] += portion * digits + (rest+1)
        else:
            numbers[i] += portion * digits

    if current > 0:
        numbers[0] += portion * digits
    if current == 0:
        numbers[0] += (portion - 1) * digits + (rest + 1)
    
    digits *= 10


print(*numbers)