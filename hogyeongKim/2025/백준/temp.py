def build_failure_function(pattern):
    """
    로직 1: PI 배열 생성
    패턴 자체를 분석해서 실패 함수 계산
    """
    m = len(pattern)
    pi = [0] * m
    j = 0
    
    print(f"=== 로직 1: PI 배열 생성 (패턴: {pattern}) ===")
    
    for i in range(1, m):
        print(f"i={i}, pattern[{i}]='{pattern[i]}', j={j}")
        
        # 핵심: 불일치 시 이동
        while j > 0 and pattern[i] != pattern[j]:
            print(f"  불일치: '{pattern[i]}' != '{pattern[j]}' → j를 {j} → {pi[j-1]}로 이동")
            j = pi[j - 1]
        
        # 일치 시 진행
        if pattern[i] == pattern[j]:
            j += 1
            print(f"  일치: '{pattern[i]}' == '{pattern[j-1]}' → j를 {j}로 증가")
        
        pi[i] = j
        print(f"  pi[{i}] = {j}")
        print(f"  현재 PI: {pi}")
        print()
    
    print(f"최종 PI 배열: {pi}")
    return pi

def kmp_search(text, pattern):
    """
    로직 2: 실제 검색
    PI 배열을 활용해서 텍스트에서 패턴 찾기
    """
    print(f"\n=== 로직 2: 실제 검색 (텍스트: {text}) ===")
    
    # 로직 1 사용해서 PI 배열 얻기
    pi = build_failure_function(pattern)
    
    n = len(text)
    m = len(pattern)
    j = 0
    matches = []
    
    print(f"PI 배열 활용한 검색 시작!")
    print()
    
    for i in range(n):
        print(f"i={i}, text[{i}]='{text[i]}', j={j}")
        
        # 핵심: 불일치 시 이동 (로직 1과 동일한 패턴!)
        while j > 0 and text[i] != pattern[j]:
            print(f"  불일치: '{text[i]}' != '{pattern[j]}' → j를 {j} → {pi[j-1]}로 이동")
            j = pi[j - 1]
        
        # 일치 시 진행
        if text[i] == pattern[j]:
            j += 1
            print(f"  일치: '{text[i]}' == '{pattern[j-1]}' → j를 {j}로 증가")
        
        # 패턴 완전 일치
        if j == m:
            match_pos = i - m + 1
            matches.append(match_pos)
            print(f"  🎉 패턴 발견! 위치: {match_pos}")
            j = pi[j - 1]  # 다음 검색을 위해
        
        print()
    
    return matches

def compare_two_logics():
    """두 로직의 유사성과 차이점 비교"""
    
    print("=== 두 로직의 비교 ===")
    print()
    
    print("🔧 로직 1 (PI 배열 생성):")
    print("   대상: 패턴 vs 패턴 자기 자신")
    print("   목적: 패턴 내부의 반복 구조 파악")
    print("   결과: PI 배열")
    print()
    
    print("🔍 로직 2 (실제 검색):")
    print("   대상: 텍스트 vs 패턴")  
    print("   목적: 텍스트에서 패턴 찾기")
    print("   결과: 매칭 위치들")
    print()
    
    print("🤝 공통점:")
    print("   1. while j > 0 and 불일치: j = pi[j-1]")
    print("   2. 일치하면 j += 1")
    print("   3. 동일한 핵심 로직!")
    print()
    
    print("🔄 차이점:")
    print("   로직 1: pattern[i] vs pattern[j]")
    print("   로직 2: text[i] vs pattern[j]")

def complete_example():
    """완전한 예제로 두 로직 실행"""
    
    text = "ABABDABABCABAB"
    pattern = "ABABCABAB"
    
    print("=== 완전한 KMP 실행 예제 ===")
    print(f"텍스트: {text}")
    print(f"패턴: {pattern}")
    print()
    
    # 전체 실행
    matches = kmp_search(text, pattern)
    
    print("="*50)
    print("🎯 최종 결과:")
    if matches:
        print(f"패턴이 발견된 위치들: {matches}")
        for pos in matches:
            print(f"  위치 {pos}: {text[pos:pos+len(pattern)]}")
    else:
        print("패턴을 찾을 수 없습니다.")

def show_algorithm_structure():
    """알고리즘 전체 구조 보여주기"""
    
    print("=== KMP 알고리즘 전체 구조 ===")
    print()
    
    print("def kmp_algorithm(text, pattern):")
    print("    # 단계 1: PI 배열 생성 (로직 1)")
    print("    pi = build_failure_function(pattern)")
    print("    ")
    print("    # 단계 2: 실제 검색 (로직 2)")
    print("    j = 0")
    print("    for i in range(len(text)):")
    print("        while j > 0 and text[i] != pattern[j]:")
    print("            j = pi[j-1]  # PI 배열 활용!")
    print("        ")
    print("        if text[i] == pattern[j]:")
    print("            j += 1")
    print("        ")
    print("        if j == len(pattern):")
    print("            print('매칭 발견!')")
    print("            j = pi[j-1]")
    print()
    
    print("✅ 핵심 포인트:")
    print("1. 로직 1과 로직 2는 **독립적**")
    print("2. 로직 1의 결과(PI 배열)를 로직 2에서 활용")
    print("3. 둘 다 동일한 패턴의 while 루프 사용")

if __name__ == "__main__":
    complete_example()
    print("\n" + "="*60 + "\n")
    compare_two_logics()
    print("\n" + "="*60 + "\n")
    show_algorithm_structure()