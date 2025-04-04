tc = int(input())
for _ in range(tc):
    floor = int(input())
    ho = int(input())

    floor0 = [i for i in range(1, ho+1)]
    for i in range(floor):
        for j in range(1, ho):
            floor0[j] += floor0[j-1]

    print(floor0[-1])