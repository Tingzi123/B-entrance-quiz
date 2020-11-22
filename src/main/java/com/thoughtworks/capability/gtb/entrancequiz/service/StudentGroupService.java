package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentGroupRepository;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentGroupService {
    private final StudentGroupRepository studentGroupRepository;
    private final StudentRepository studentRepository;

    public StudentGroupService(StudentGroupRepository studentGroupRepository, StudentRepository studentRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.studentRepository = studentRepository;
    }

    public List<StudentGroup> getAllStudentGroups() {
        studentGroupRepository.deleteAll();
        shuffleStudents();
        return studentGroupRepository.findAll();
    }

    private void shuffleStudents() {
        StudentGroup[] studentGroups = new StudentGroup[6];

        for (int index = 0; index < studentGroups.length; index++) {
            studentGroups[index] = new StudentGroup();
        }

        List<Student> students = studentRepository.getAllStudent();

        List<Student> tempStudents = new ArrayList<>();
        tempStudents.addAll(students);

        // TODO GTB-知识点: - 打乱顺序可以了解下Collections.shuffle()
        Random random = new Random();

        if (tempStudents.size() > 0) {
            int start = 0;
            while (tempStudents.size() > 0) {
                int rand = random.nextInt(tempStudents.size());
                studentGroups[start % 6].setId(start % 6 + 1);
                if (studentGroups[start % 6].getStudents() == null) {
                    studentGroups[start % 6].setStudents(new ArrayList<>());
                }
                studentGroups[start % 6].getStudents().add(tempStudents.get(rand));
                tempStudents.remove(tempStudents.get(rand));
                start++;
            }
        }

        for (int m = 0; m < 6; m++) {
            studentGroupRepository.save(m, studentGroups[m]);
        }
    }
}
