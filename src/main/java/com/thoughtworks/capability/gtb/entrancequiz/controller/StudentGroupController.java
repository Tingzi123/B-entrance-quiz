package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "groups")
public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping
    public ResponseEntity getAllStudentGroups() {
        List<StudentGroup> studentGroups=studentGroupService.getAllStudentGroups();
        return ResponseEntity.ok().body(studentGroups);
    }
}
