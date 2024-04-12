package com.example.demo.domain.students.service;

import com.example.demo.domain.students.entity.Student;
import com.example.demo.domain.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
