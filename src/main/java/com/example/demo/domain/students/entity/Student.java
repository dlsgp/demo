package com.example.demo.domain.students.entity;

import com.example.demo.domain.lectures.entity.Lecture;
import com.example.demo.domain.students.request.StudentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_lecture", // 연결 테이블 이름
            joinColumns = @JoinColumn(name = "student_id"), // 현재 엔티티를 참조하는 컬럼
            inverseJoinColumns = @JoinColumn(name = "lecture_id") // 반대쪽 엔티티를 참조하는 컬럼
    )
    private Set<Lecture> lectures = new HashSet<>();

    // 정적 팩토리 메소드 수정: 생성자 대신 정적 팩토리 메소드 사용
    public static Student of(StudentRequest request){
        Student student = new Student();
        student.setName(request.getName());
        return student;
    }
}

