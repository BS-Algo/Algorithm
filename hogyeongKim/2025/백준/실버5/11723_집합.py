import sys
input = sys.stdin.readline

m = int(input().rstrip())
s = set()


for _ in range(m):
    order = input().strip()
    
    if order == "all":
        s = set(range(1, 21))
    elif order == "empty":
        s = set()
    else:
        command, number = order.split()
        number = int(number)
        
        if command == "add":
            s.add(number)
        elif command == "remove":
            if number in s:
                s.remove(number)
        elif command == "check":
            print(1 if number in s else 0)
        elif command == "toggle":
            if number in s:
                s.remove(number)
            else:
                s.add(number)