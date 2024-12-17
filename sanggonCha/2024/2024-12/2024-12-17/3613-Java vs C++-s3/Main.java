
    // 첫 단어는 소문자로 쓰고, 다음 단어부터는 첫 문자만 대문자로 쓴다
    private static boolean isJavaFormat(String inputs) {
        return inputs.matches("^[a-z][a-zA-Z]*$");
    }
    /*
    ^            : 문자열의 시작
    [a-z]        : 첫 글자는 소문자 (a부터 z)
    [a-zA-Z]*    : 그 뒤에 0개 이상의 소문자 또는 대문자가 올 수 있음
    $            : 문자열의 끝
    */

    // C++에서는 변수명에 소문자만 사용한다. 단어와 단어를 구분하기 위해서 밑줄('_')을 이용한다.
    private static boolean isCppFormat(String inputs) {
        return inputs.matches("^[a-z]+(_[a-z]+)*$*");
    }
    /*
    ^            : 문자열의 시작
    [a-z]+       : 소문자(a-z)가 1개 이상 등장
    (_[a-z]+)*   : 밑줄(_)이 있고 그 뒤에 소문자(a-z)가 1개 이상 등장하는 패턴이 0개 이상 반복됨
    $            : 문자열의 끝
    */
