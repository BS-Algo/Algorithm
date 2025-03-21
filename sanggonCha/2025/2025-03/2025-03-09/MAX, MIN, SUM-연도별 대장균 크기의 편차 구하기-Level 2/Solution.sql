WITH
    -- 1. 연도별로 가장 큰 대장균 찾기
    MAX_SIZE_PER_YEAR AS (
        SELECT
            YEAR (DIFFERENTIATION_DATE) AS YEAR,
            MAX(SIZE_OF_COLONY) AS MAX_SIZE
        FROM
            ECOLI_DATA
        GROUP BY
            YEAR (DIFFERENTIATION_DATE)
    )
    -- 2. 연도별로 JOIN하기
SELECT
    P.YEAR,
    P.MAX_SIZE - E.SIZE_OF_COLONY AS YEAR_DEV,
    E.ID
FROM
    ECOLI_DATA E
    JOIN MAX_SIZE_PER_YEAR P ON YEAR (E.DIFFERENTIATION_DATE) = P.YEAR
    -- 3. 정렬
ORDER BY
    P.YEAR,
    YEAR_DEV;