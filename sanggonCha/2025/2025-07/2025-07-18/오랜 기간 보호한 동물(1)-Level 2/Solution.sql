SELECT
    NAME,
    DATETIME
FROM
    ANIMAL_INS
WHERE
    ANIMAL_ID NOT IN (
        SELECT
            I.ANIMAL_ID
        FROM
            ANIMAL_INS I
            JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
    )
ORDER BY
    DATETIME
LIMIT
    3;