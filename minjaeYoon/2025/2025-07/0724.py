# 로그인 성공?
def solution(id_pw, db):
    for user in db:
        if user[0] == id_pw[0]:
            return "login" if user[1] == id_pw[1] else "wrong pw"
    return "fail"

print(solution(["meosseugi", "1234"], [["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]))

# ":= python 3.8부터 생긴 기능 할당과 비교를 동시에"