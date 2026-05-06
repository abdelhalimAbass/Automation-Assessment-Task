
-- 1-Detect duplicates 

SELECT movie_name, released_year, COUNT(*) AS duplicate_count
FROM movies
GROUP BY movie_name, released_year
HAVING COUNT(*) > 1;

--2-Highest rated movie : 

SELECT movie_name, rating
FROM movies
WHERE rating = (SELECT MAX(rating) FROM movies);

--3-Count per year 

SELECT released_year, COUNT(*) AS total_movies
FROM movies
GROUP BY released_year
ORDER BY released_year;

--4-Lowest rating in 2001 : 

SELECT movie_name, rating
FROM movies
WHERE released_year = 2001
AND rating = (
    SELECT MIN(rating)
    FROM movies
    WHERE released_year = 2001
);

