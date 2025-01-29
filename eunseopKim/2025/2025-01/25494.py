num = int(input()) 
for i in range(num): 
    x, y, z = map(int, input().split()) 
    m = min(x, min(y, z)) 
    print(m)