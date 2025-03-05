/*
다중컬럼 서브쿼리
  - 서브쿼리 결과가 여러 컬럼을 리턴하는 형태
  - 메인쿼리와 비교하는 컬럼이 2개 이상인 형태
  - 대소 비교 조건 전달 불가능 (두 값을 동시에 묶어 대소 비교 불가)
*/

-- EMP 테이블에서 부서별 최대 급여자 확인

-- 부서별 최대 급여 확인
SELECT DEPTNO, MAX(SAL)
  FROM EMP
  GROUP BY DEPTNO;

-- 위 결과를 메인쿼리의 비교 상수로 전달
SELECT EMPTNO, ENAME, SAL, DEPTNO
  FROM EMP
  WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL)
                            FROM EMP
                            GROUP BY DEPTNO);

-- 비교 순서가 중요하다