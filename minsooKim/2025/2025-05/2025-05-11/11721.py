word = input().rstrip()
num = len(word)
if num > 10:
    num_2 = num // 10
    last = num % 10
    for i in range(num_2):
        print(word[ i  * 10: (i+1) * 10])
    if last != 0:
        print(word[-last::])
else:
    print(word)