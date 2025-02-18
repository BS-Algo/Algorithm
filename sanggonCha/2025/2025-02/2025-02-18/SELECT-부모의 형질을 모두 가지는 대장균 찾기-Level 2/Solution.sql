SELECT C.ID,
    C.GENOTYPE,
    P.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA C
    JOIN ECOLI_DATA P ON C.PARENT_ID = P.ID
WHERE P.GENOTYPE = (P.GENOTYPE & C.GENOTYPE)
ORDER BY C.ID;