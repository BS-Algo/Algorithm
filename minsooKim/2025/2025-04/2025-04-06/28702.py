def fizzbuzz(n):
    if n % 15 == 0:
        return "FizzBuzz"
    elif n % 3 == 0:
        return "Fizz"
    elif n % 5 == 0:
        return "Buzz"
    else:
        return str(n)

a = input()
b = input()
c = input()

for i in range(1, 10000000):
    if fizzbuzz(i) == a and fizzbuzz(i+1) == b and fizzbuzz(i+2) == c:
        print(fizzbuzz(i+3))
        break