package com.Security.SBandJwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class STudentController {

private List<Student>stu=new ArrayList<>(List.of(
        new Student(1,"manish","timilsina"),
        new Student(2,"man","timil")
));

    @GetMapping("/students")
    public List<Student> getAll(){
return stu;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student stud){
        stu.add(stud);
        return stud;
    }

}
