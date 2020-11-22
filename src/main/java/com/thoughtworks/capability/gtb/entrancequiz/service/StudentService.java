package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private StudentRepository studentRepository;

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

    // TODO GTB-工程实践: - 应该创建专门的对象来表示Group
    public ArrayList<Student>[] getAllStudentByGroup() {
        // TODO GTB-工程实践: - Magic Number
        // TODO GTB-工程实践: - 不推荐使用数组
        ArrayList<Student>[] groupStudent = new ArrayList[6];

        for (int i = 0; i < groupStudent.length; i++) {
            groupStudent[i] = new ArrayList();
        }
        shuffleStudents(groupStudent);

        for (ArrayList<Student> students : groupStudent) {
            Collections.sort(students, Comparator.comparingInt(Student::getId));
        }

        return groupStudent;
    }

    private void shuffleStudents(ArrayList<Student>[] groupStudent) {
        List<Student> students = studentRepository.getAllStudent();

        List<Student> tempStudents = new ArrayList<>();
        tempStudents.addAll(students);

        // TODO GTB-知识点: - 打乱顺序可以了解下Collections.shuffle()
        Random random = new Random();

        if (tempStudents.size() > 0) {
            int start = 0;
            while (tempStudents.size() > 0) {
                int rand = random.nextInt(tempStudents.size());
                groupStudent[start % 6].add(tempStudents.get(rand));
                tempStudents.remove(tempStudents.get(rand));
                start++;
            }
        }
    }

    public int addStudent(String name) {
        return studentRepository.addStudent(name);
    }
}
