package org.example.springdatajpa.service;

import org.example.springdatajpa.entity.Student;
import org.example.springdatajpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(int id, Student student) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);

            if (studentOptional.isPresent()) {
                Student newStudent = studentOptional.get();

                newStudent.setName(student.getName());
                newStudent.setSurname(student.getSurname());
                newStudent.setBirtOfDate(student.getBirtOfDate());
                newStudent.setStudentNumber(student.getStudentNumber());

                return studentRepository.save(newStudent);
        } }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
