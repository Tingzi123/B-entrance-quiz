package com.thoughtworks.capability.gtb.entrancequiz.repo;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {
    public final List<Student> students;

    public StudentRepo() {
        this.students = null;
    }

    public List<Student> getAllStudent(){
        return students;
    }
}
