package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        if (students == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(students);
    }

    @CrossOrigin
    @GetMapping(value = "/students/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllStudentByGroup() {
        ArrayList<Student>[] groupStudents = studentService.getAllStudentByGroup();
        if (groupStudents == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(groupStudents);
    }

    @CrossOrigin
    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addStudent(@RequestBody String name) {
        int index = studentService.addStudent(name);
        return ResponseEntity.ok().body(index);
    }
}
