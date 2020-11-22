package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentGroupRepository {
    private final Map<Integer, StudentGroup> studentGroups;

    public StudentGroupRepository() {
        studentGroups = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            studentGroups.put(i, new StudentGroup());
        }
    }

    public List<StudentGroup> findAll() {
        return new ArrayList<>(studentGroups.values());
    }

    public void save(int index,StudentGroup studentGroup){
        studentGroups.put(index,studentGroup);
    }

    public void deleteAll(){
        Set<Integer> keys=studentGroups.keySet();
        for (Integer key:keys){
            studentGroups.put(key,new StudentGroup());
        }
    }
}
