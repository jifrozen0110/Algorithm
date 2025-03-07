
SELECT ID, 
case when SIZE_OF_COLONY<=100 then 'LOW' else
case when SIZE_OF_COLONY<=1000 then 'MEDIUM' else
'HIGH' END END as SIZE from ECOLI_DATA