SELECT p.`id`, p.`date` as 'date_and_time',
p.`description`, COUNT(c.`comment`) as 'commentsCount'
FROM `photos` as p
JOIN `comments` as c
ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY commentsCount DESC, `id`
LIMIT 5;