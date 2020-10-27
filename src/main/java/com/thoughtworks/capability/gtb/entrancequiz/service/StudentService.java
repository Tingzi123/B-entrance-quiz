package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudent() {
        List<Student> students = studentRepo.getAllStudent();

        if (students.size() != 0) {
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getId() - o2.getId();
                }
            });
        }
        return students;
    }

    public ArrayList<Student>[] getAllStudentByGroup() {
        ArrayList<Student>[] groupStudent = new ArrayList[6];

        for(int i=0;i<groupStudent.length;i++) {
            groupStudent[i] = new ArrayList();
        }

        List<Student> students = studentRepo.getAllStudent();

        Random random = new Random();

        if (students.size() > 0) {
            for (Student stu : students) {
                if (stu.getId() < students.size() / 6 * 6) {
                    int rand = random.nextInt(6);
                    groupStudent[rand].add(stu);
                } else {
                    int rand = random.nextInt(students.size() % 6);
                    groupStudent[rand].add(stu);
                }
            }
        }
        return groupStudent;
    }

    public int addStudent(String name) {
        return studentRepo.addStudent(name);
    }
}
