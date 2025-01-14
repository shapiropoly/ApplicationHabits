SELECT conname, confdeltype
FROM pg_constraint
WHERE conname = 'check_up_user_to_habit_id_fkey';
