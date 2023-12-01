package top.lxyi.train.business.controller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import top.lxyi.train.business.config.DataGenerator;
import top.lxyi.train.business.domain.Student;
import com.github.javafaker.Faker;
import top.lxyi.train.business.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// StudentController.java
@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students;

    // 假数据生成器
    private DataGenerator dataGenerator = new DataGenerator();

    public StudentController() {
        // 生成 10w 条学生数据
        this.students = dataGenerator.generateStudents(100000);
    }

    // 根据关键字查询学生
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String keyword) {
        return students.stream()
                .filter(student ->
                        student.getName().contains(keyword) ||
                                student.getPhoneNumber().contains(keyword) ||
                                student.getEmail().contains(keyword) ||
                                student.getSchool().contains(keyword))
                .collect(Collectors.toList());
    }
}

