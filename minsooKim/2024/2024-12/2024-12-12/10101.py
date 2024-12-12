triangle = []
for _ in range(3):
    angle = int(input())
    triangle.append(angle)
a = triangle[0]
b = triangle[1]
c = triangle[2]

if a + b + c == 180:
    if a == b == c == 60:
        print("Equilateral")
    elif a == b or a == c or b == c:
        print("Isosceles")
    elif a != b and a!=c and b!=c :
        print("Scalene")
else:
    print("Error")
