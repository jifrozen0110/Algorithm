-- 코드를 입력하세요
SELECT USER_ID,PRODUCT_ID from ONLINE_SALE
group by user_id, product_id having count(*)>1
order by USER_ID asc, PRODUCT_ID desc