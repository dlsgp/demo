package com.example.demo.domain.lectures.controller;

import com.example.demo.domain.lectures.entity.Lecture;
import com.example.demo.domain.lectures.service.LectureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lectures")
@Tag(name = "lectures", description = "강좌 관련 API")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService){
        this.lectureService = lectureService;
    }
    @PostMapping
    @Operation(summary = "새로운 강좌를 추가 합니다.")
    public ResponseEntity<Lecture> addLecture(@RequestBody Lecture lecture){
        Lecture saveLecture = lectureService.saveLecture(lecture);
        return new ResponseEntity<>(saveLecture, HttpStatus.CREATED);
    }
//    @GetMapping("/{id}")
//    @Operation(summary = "하나의 강좌를 조회합니다.", responses = {
//            @ApiResponse(responseCode = "200", description = "정상적으로 조회 완료"),
//            @ApiResponse(responseCode = "404", description = "존재하지 않는 강좌를 조회한 경우")
//    })
//    public ResponseEntity<Lecture> getLecture(@PathVariable Long id) {
//        return lectureService.findById(id)
//                .map(lecture -> ResponseEntity.ok(lecture))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @DeleteMapping("/{id}")
    @Operation(summary = "하나의 강좌를 삭제합니다.")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id){
        lectureService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @Operation(summary = "학생이름으로 수강중인 강좌 조회 API, 조회되면 학생을 내려주고 없으면 전체학생을 내려준다.")
    public ResponseEntity<List<Lecture>> getLectures(@RequestParam(required = false) String student){
        if(student != null && !student.isEmpty()){
            return new ResponseEntity<>(lectureService.findByStudentName(student), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(lectureService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "하나의 강좌를 조회한다")
    public ResponseEntity<Lecture> getLectureId(@Parameter(description = "강좌 ID") @PathVariable Long id){
        return lectureService.findById(id)
                .map(lecture -> new ResponseEntity<>(lecture, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
