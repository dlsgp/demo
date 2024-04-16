package com.example.demo.domain.students.controller;

import com.example.demo.domain.students.entity.Student;
import com.example.demo.domain.students.request.StudentRequest;
import com.example.demo.domain.students.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Log4j2
@Tag(name = "students", description = "학생 관련 API")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        return  new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return studentService.findById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping // 학생 path 받으면 전체 학생 리스트 리턴
    @Operation(summary = "전체 학생 리스트를 내려 준다.")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.findAll();
        if(students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
