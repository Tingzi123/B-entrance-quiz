package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.getAllStudent();

        if (students.size() != 0) {
            Collections.sort(students, Comparator.comparingInt(Student::getId));
        }
        return students;
    }

    public int addStudent(String name) {
        return studentRepository.addStudent(name);
    }
}
