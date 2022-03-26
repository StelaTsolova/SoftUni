SELECT CONCAT_WS(' ', u.`id`, u.`username`) as 'id_username',
u.`email`
FROM `users` as u
JOIN `users_photos` as up
ON up.`user_id` = u.`id`
WHERE up.`user_id` = up.`photo_id`
ORDER BY u.`id`;