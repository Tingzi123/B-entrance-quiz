package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ResponseEntity getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        // TODO GTB-工程实践: - 代码中应该保证List总不为null
        if (students == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(students);
    }


    @GetMapping(value = "/students/group")
    // TODO GTB-完成度: - 分组接口返回的组不包含组名
    public ResponseEntity getAllStudentByGroup() {
        ArrayList<Student>[] groupStudents = studentService.getAllStudentByGroup();
        if (groupStudents == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(groupStudents);
    }

    @PostMapping(value = "/student")
    public ResponseEntity addStudent(@RequestBody String name) {
        int index = studentService.addStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(index);
    }
}
