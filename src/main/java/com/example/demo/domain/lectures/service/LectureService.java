package com.example.demo.domain.lectures.service;

import com.example.demo.domain.lectures.entity.Lecture;
import com.example.demo.domain.lectures.repository.LectureRepository;
import com.example.demo.domain.students.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }

    public Lecture saveLecture(Lecture lecture){
        return lectureRepository.save(lecture);
    }

    public Optional<Lecture> findById(Long id){
        return lectureRepository.findById(id);
    }
    public List<Lecture> findAll(){
        return lectureRepository.findAll();
    }

    public List<Lecture> findByStudentName(String studentName){
        return lectureRepository.findByStudentsName(studentName);
    }

    public void deleteById(Long id){
        lectureRepository.deleteById(id);
    }


}
