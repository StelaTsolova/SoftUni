SELECT c.`name`, COUNT(g.`id`) as 'games_count', 
ROUND(AVG(g.`budget`), 2) as 'avg_budget', 
MAX(g.`rating`) as max_rating
FROM `categories` as c
JOIN `games_categories` as gc
ON gc.`category_id` = c.`id`
JOIN `games` as g
ON gc.`game_id` = g.`id`
GROUP BY c.`id`
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.`name`;