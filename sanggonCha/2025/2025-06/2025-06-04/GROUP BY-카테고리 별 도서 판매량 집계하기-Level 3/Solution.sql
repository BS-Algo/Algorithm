SELECT
    COUNT(ID) AS FISH_COUNT,
    MAX(LENGTH) AS MAX_LENGTH,
    FISH_TYPE
FROM
    FISH_INFO
WHERE
    FISH_TYPE IN (
        SELECT
            FISH_TYPE
        FROM
            FISH_INFO
        GROUP BY
            FISH_TYPE
        HAVING
            AVG(
                CASE
                    WHEN LENGTH IS NULL THEN 10
                    ELSE LENGTH
                END
            ) >= 33
    )
GROUP BY
    FISH_TYPE
HAVING
    MAX_LENGTH >= 33
ORDER BY
    FISH_TYPE;