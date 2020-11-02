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
            // TODO GTB-知识点: - 可以使用lambda表达式简化代码
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getId() - o2.getId();
                }
            });
        }
        return students;
    }

    // TODO GTB-工程实践: - 长方法，建议抽子方法来提高可读性
    // TODO GTB-工程实践: - 应该创建专门的对象来表示Group
    public ArrayList<Student>[] getAllStudentByGroup() {
        // TODO GTB-工程实践: - Magic Number
        // TODO GTB-工程实践: - 不推荐使用数组
        ArrayList<Student>[] groupStudent = new ArrayList[6];

        for (int i = 0; i < groupStudent.length; i++) {
            groupStudent[i] = new ArrayList();
        }

        // TODO GTB-工程实践: - 变量不表意
        List<Student> studentsRepo = studentRepo.getAllStudent();

        List<Student> tempStudents=new ArrayList<>();
        tempStudents.addAll(studentsRepo);

        // TODO GTB-知识点: - 打乱顺序可以了解下Collections.shuffle()
        Random random = new Random();

        if (tempStudents.size() > 0) {
            int start = 0;
            while (tempStudents.size() > 0) {
                int rand = random.nextInt(tempStudents.size());
                // TODO GTB-工程实践: - 注意代码风格，需要适当的添加空格
                groupStudent[start%6].add(tempStudents.get(rand));
                tempStudents.remove(tempStudents.get(rand));
                start++;
            }
        }

        for (ArrayList<Student> students:groupStudent) {
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getId() - o2.getId();
                }
            });
        }

        return groupStudent;
    }

    public int addStudent(String name) {
        return studentRepo.addStudent(name);
    }
}
