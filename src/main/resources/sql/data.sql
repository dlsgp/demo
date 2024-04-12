-- students
INSERT INTO students (id, name) VALUES (100, 'hong');
INSERT INTO students (id, name) VALUES (200, 'han');

-- lectures
INSERT INTO lectures (id, title, curriculum, created_date) VALUES (100, 'java', '자바 프로그래밍', '2024-04-12');
INSERT INTO lectures (id, title, curriculum, created_date) VALUES (200, 'spring', '스프링 프로그래밍', '2024-04-12');

-- Reviews
INSERT INTO reviews (id, lecture_id, content, rating, created_date) VALUES (100, 100, '재미있어요.', 5.0, '2024-04-13');
INSERT INTO reviews (id, lecture_id, content, rating, created_date) VALUES (200, 200, '신나요.', 4.5, '2024-04-13');

-- lecturesstudents - many-to-many relationship between lectures and students
INSERT INTO lectures_students (lecture_id, student_id) VALUES (100, 100);
INSERT INTO lectures_students (lecture_id, student_id) VALUES (200, 200);