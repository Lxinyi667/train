package top.lxyi.train.business.service;

import org.springframework.stereotype.Service;
import top.lxyi.train.business.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
