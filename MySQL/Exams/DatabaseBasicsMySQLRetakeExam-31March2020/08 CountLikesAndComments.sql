SELECT p.`id` as 'photo_id', 
(SELECT COUNT(l.`photo_id`) FROM `likes` as l WHERE l.`photo_id` = p.`id`) as 'likes_count', 
(SELECT COUNT(c.`photo_id`) FROM `comments` as c WHERE c.`photo_id` = p.`id`) as 'comments_count'
FROM `photos` as p
ORDER BY likes_count DESC, comments_count DESC, photo_id;