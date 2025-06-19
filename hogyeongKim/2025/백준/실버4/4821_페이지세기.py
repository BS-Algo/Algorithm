while True:
    result = set()
    n = int(input())
    if n == 0:
        break
    pages = list(input().split(','))
    for page in pages:
        if '-' in page:
            low, high = map(int, page.split('-'))
        else:
            low, high = int(page), int(page)
        if high > n:
            high = n
        if low > high:
            continue
        else:
            for i in range(low, high+1):
                result.add(i)
    print(len(result))