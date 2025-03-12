/*
index	col1	col2
1	2	Null
2	3	6
3	5	5
4	6	3
5	Null	3
*/

SELECT count(col2)
FROM TABLE
WHERE col1 in(2,3) or col2 in(3,5);

-- 4

/*
index	name	score
1	Kim	95
2	Gun	90
3	Son	80
4	Jung	60
*/

SELECT name, score FROM 성적 ORDER BY score DESC

-- SELECT name, score FROM 성적 ( 1 ) BY ( 2 ) ( 3 )
-- 답) 1. ORDER / 2. score / 3. DESC

--(    1   ) 테이블명  (     2    )  컬럼 = 값 WHRE 점수 >= 90;
-- 1. UPDATE 2. SET
UPDATE 테이블명  SET 컬럼 = 값 WHRE 점수 >= 90;


/*
EMPNO	SAL
100	1000
200	3000
300	1500
*/

SELECT COUNT(*) FROM 급여
WHERE EMPNO > 100 AND SAL >= 3000 OR EMPNO = 200;

-- 1

/*
Q) 다음 조건을 만족하면서 학과별로 튜플 수가 얼마인지 구하는 SQL문을 쓰시오.
- 대소문자를 구분하지 않는다.
- WHERE 구문을 사용하지 않는다.
- GROUP BY 를 사용한다.
- 세미콜론(;)은 생략 가능하다.
- 별칭(AS)을 사용해야 한다. (별칭 사용 시 별칭은 작은 따옴표를 써야 함)
- 집계 함수를 사용해야 한다.

[학생]

학과	학생
전기	이순신
컴퓨터	안중근
컴퓨터	윤봉길
전자	이봉창
전자	강우규
 

[결과]

학과	학과별 튜플수
전기	1
컴퓨터	2
전자	2

*/

SELECT 학과 , COUNT(학과) AS 학과별튜플수 FROM 학생 GROUP BY 학과;