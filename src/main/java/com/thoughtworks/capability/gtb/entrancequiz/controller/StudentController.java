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
    // TODO GTB-知识点: - 构造函数注入时推荐添加final
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin
    // TODO GTB-知识点: - @CrossOrigin可以放在类上
    // TODO GTB-知识点: - @GetMapping可以省略produces属性
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    // TODO GTB-知识点: - 没有使用泛型
    public ResponseEntity getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        // TODO GTB-工程实践: - 代码中应该保证List总不为null
        if (students == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(students);
    }

    @CrossOrigin
    @GetMapping(value = "/students/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    // TODO GTB-完成度: - 分组接口返回的组不包含组名
    public ResponseEntity getAllStudentByGroup() {
        ArrayList<Student>[] groupStudents = studentService.getAllStudentByGroup();
        if (groupStudents == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(groupStudents);
    }

    @CrossOrigin
    // TODO GTB-知识点: - 违反Restful实践, url不合理
    // TODO GTB-知识点: - 违反Restful实践, Post请求成功后应该返回201
    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addStudent(@RequestBody String name) {
        int index = studentService.addStudent(name);
        return ResponseEntity.ok().body(index);
    }
}
