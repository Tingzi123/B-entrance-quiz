package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        // TODO GTB-工程实践: - 代码中应该保证List总不为null
        if (students == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody String name) {
        int index = studentService.addStudent(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(index);
    }
}
