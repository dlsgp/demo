-- students  sql 스크립트를 한 테이블씩 실행 한 후 워크벤치에서 행이 추가되었는지 확인 합니다.
INSERT INTO students (id, name) VALUES (null, 'hong');
INSERT INTO students (id, name) VALUES (null, 'han');

-- lectures
INSERT INTO lectures (id, title, curriculum, created_date) VALUES (null, 'java', '자바 프로그래밍', '2024-04-12');
INSERT INTO lectures (id, title, curriculum, created_date) VALUES (null, 'spring', '스프링 프로그래밍', '2024-04-12');

-- lecturesstudents - many-to-many relationship between lectures and students
INSERT INTO lectures_students (lecture_id, student_id) VALUES (1, 1);
INSERT INTO lectures_students (lecture_id, student_id) VALUES (2, 2);

-- Reviews
INSERT INTO reviews (id, lecture_id, content, rating, created_date) VALUES (null, 1, '재미있어요.', 5.0, '2024-04-13');
INSERT INTO reviews (id, lecture_id, content, rating, created_date) VALUES (null, 2, '신나요.', 4.5, '2024-04-13');
