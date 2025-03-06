/*
윈도우 함수 연산 대상 및 범위
ROWS|RANGE BETWEEN A AND B

1. 연산 대상
1-1) ROWS : 연산 진행할 행 지정
1-2) RANGE(DEFAULT) : 연산 범위 지정

2. 범위
2-1) A : 시작점
  - CURRENT ROW : 현재 행부터
  - UNBOUNDED PRECEDING : 처음부터(DEFAULT)
  - N PRECEDING : N 이전부터

2-2) B : 마지막 지점 정의
  - CURRENT ROW : 현재 범위까지 (DEFAULT)
  - UNBOUNDED FOLLOWING : 마지막까지
  - N FOLLOWING : N 이후까지
*/

SELECT NO, SAL,
      SUM(SAL) OVER(ORDER BY SAL) AS RESULT1,
      SUM(SAL) OVER(ORDER BY SAL
                    RANGE BETWEEN UNBOUNDED PRECEDING
                          AND CURRENT ROW) AS RESULT2
  FROM WINDOW_TAB1;

SELECT NO, SAL,
      SUM(SAL) OVER(ORDER BY SAL
                    RANGE BETWEEN 10 PRECEDING
                          AND 10 FOLLOWING) AS RESULT
  FROM WINDOW_TAB1;

SELECT NO, SAL,
      SUM(SAL) OVER(ORDER BY SAL
                    RANGE BETWEEN UNBOUNDED PRECEDING
                          AND CURRENT ROW) AS RESULT
  FROM WINDOW_TAB1;
