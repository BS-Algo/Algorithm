# 세 개의 구분자
def solution(myStr):
    import re
    answer = []
    myStr = re.split('[abc]', myStr)
    answer = [x for x in myStr if x]
    if not answer:
        return ['EMPTY']
    return answer

myStr = "baconlettucetomato"
myStr = "cabab"		

print(solution(myStr))

# 정규식으로 풀기

# l로 만들기
def solution(myString):
    myString = [ord(x) for x in myString]
    for i in range(len(myString)):
        if myString[i] < ord('l'):
            myString[i] = ord('l')
    myString = [chr(x) for x in myString]
    return ''.join(myString)

myString = "abcdevwxyz"

print(solution(myString))

# 이런 함수도 존재함
def solution(myString):
    return myString.translate(str.maketrans('abcdefghijk', 'lllllllllll'))

# 1. 기본적인 문자 치환
text = "Hello World"
# 'H' -> 'h', 'W' -> 'w'로 변환
trans_table = str.maketrans('HW', 'hw')
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # hello world
print()

# 2. 숫자를 다른 문자로 변환
text = "I have 123 apples and 456 oranges"
# 숫자를 *로 변환
trans_table = str.maketrans('0123456789', '**********')
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # I have *** apples and *** oranges
print()

# 3. 딕셔너리를 사용한 변환
text = "Hello World"
# 딕셔너리로 여러 문자 매핑
trans_table = str.maketrans({'H': 'h', 'W': 'w', 'o': '0'})
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # hell0 w0rld
print()

# 4. 특정 문자 제거 (세 번째 인자 사용)
text = "Hello, World! 123"
# 'l'을 'L'로 바꾸고, 쉼표와 느낌표, 숫자 제거
trans_table = str.maketrans('l', 'L', ',!123')
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # HeLLo WorLd 
print()

# 5. 한글 변환 예제
text = "안녕하세요 반갑습니다"
# 특정 한글 문자 변환
trans_table = str.maketrans('안녕', '잘가')
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # 잘가하세요 반갑습니다
print()

# 6. 실용적인 예제 - 특수문자 제거
text = "Hello@World#123!Python$"
# 특수문자를 공백으로 변환
special_chars = "@#!$%^&*(){}[]|\\:;\"'<>?,./"
trans_table = str.maketrans(special_chars, ' ' * len(special_chars))
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # Hello World 123 Python 
print()

# 7. ROT13 암호화 구현
def rot13(text):
    # 알파벳을 13자리씩 이동
    lowercase = 'abcdefghijklmnopqrstuvwxyz'
    uppercase = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    rot13_lower = lowercase[13:] + lowercase[:13]
    rot13_upper = uppercase[13:] + uppercase[:13]
    
    trans_table = str.maketrans(lowercase + uppercase, rot13_lower + rot13_upper)
    return text.translate(trans_table)

text = "Hello World"
encrypted = rot13(text)
decrypted = rot13(encrypted)  # ROT13은 자기 자신이 역함수
print(f"원본: {text}")
print(f"암호화: {encrypted}")
print(f"복호화: {decrypted}")
print()

# 8. 성능 비교 - translate vs replace
import time

text = "a" * 100000 + "b" * 100000 + "c" * 100000

# translate 사용
start = time.time()
trans_table = str.maketrans('abc', 'xyz')
result1 = text.translate(trans_table)
translate_time = time.time() - start

# replace 연속 사용
start = time.time()
result2 = text.replace('a', 'x').replace('b', 'y').replace('c', 'z')
replace_time = time.time() - start

print(f"translate 시간: {translate_time:.6f}초")
print(f"replace 시간: {replace_time:.6f}초")
print(f"translate가 {replace_time/translate_time:.1f}배 빠름")
print(f"결과 동일: {result1 == result2}")
print()

# 9. None을 사용한 문자 삭제 (딕셔너리 방식)
text = "Hello123World456"
# 숫자만 제거
trans_table = str.maketrans({str(i): None for i in range(10)})
result = text.translate(trans_table)
print(f"원본: {text}")
print(f"결과: {result}")  # HelloWorld