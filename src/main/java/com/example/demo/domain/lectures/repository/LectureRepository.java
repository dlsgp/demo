package com.example.demo.domain.lectures.repository;

import com.example.demo.domain.lectures.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByStudentsName(String name);
    List<Lecture> findByTitleContaining(String keyword);


}
