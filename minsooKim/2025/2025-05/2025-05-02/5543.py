N = 5
a = int(input())
b = int(input())
c =  int(input())
cola = int(input())
sida = int(input())

A = a + cola - 50
A_1 = a + sida - 50
B = b + cola - 50
B_1 = b + sida - 50
C = c + cola - 50
C_1 = c + sida - 50
arr = [A, A_1, B, B_1, C, C_1]
print(min(arr))
