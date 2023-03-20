package com.joaoalmeida.restapi.rest.oldstuff;

import com.joaoalmeida.restapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudent = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudent.add(new Student("Alice", "Smith"));
        theStudent.add(new Student("Bob", "Johnson"));
        theStudent.add(new Student("Charlie", "Brown"));
        theStudent.add(new Student("David", "Lee"));
        theStudent.add(new Student("Emily", "Wang"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudent;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= theStudent.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Wrong Id Number");
        }
        return theStudent.get(studentId);
    }
}
