package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Poul", "Java from Beginner"));
                put(2, new Student(2, "Kate", "Math"));
                put(3, new Student(3, "Sven", "Economy"));
                put(4, new Student(4, "Andrew", "Computer Technology"));

            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student tempStudent = students.get(student.getId());
        tempStudent.setName(student.getName());
        tempStudent.setCourse(student.getCourse());
        this.students.put(student.getId(), tempStudent);
    }

    @Override
    public void addStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
