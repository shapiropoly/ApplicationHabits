ALTER TABLE check_up
DROP CONSTRAINT check_up_user_to_habit_id_fkey;

ALTER TABLE check_up
ADD CONSTRAINT check_up_user_to_habit_id_fkey
FOREIGN KEY (user_to_habit_id) REFERENCES users_to_habits (id) ON DELETE CASCADE;
