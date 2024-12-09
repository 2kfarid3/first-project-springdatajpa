package org.example.springdatajpa.controller;

import org.example.springdatajpa.entity.Student;
import org.example.springdatajpa.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);



    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/new")
    public Student createStudent(@RequestBody Student student) {
        logger.info("Creating a new student with name: {}", student.getName());

        Student createdStudent = studentService.createStudent(student);

        logger.info("Student created with id: {}", createdStudent.getId());

        return createdStudent;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/edit/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

}
