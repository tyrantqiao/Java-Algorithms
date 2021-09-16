# mysql题目

## 大国

> 人口限制或者领土限制

```mysql
select name,population,area from world  where area>3000000 or population>25000000;
```