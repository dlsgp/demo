## 온라인 강좌 URI 설계

### 강좌 추가
- POST/ lecture

### 강좌 목록 조회
- GET / lectures

## 특정 강좌 조회
- GET / lectures/{lectureID}

## 학생이 수강하고 있는 강좌 조회
- GET / lectures/ {lectureID}

## 학생이름으로 수강과목 조회
- GET / lectures?student={studentName}

## 강좌에 대한 리뷰
- GET/ lectures/{lectureID}/review

## API 구현에 필요한 테이블 목록
- lecture
- student
- review