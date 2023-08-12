package com.example.librarymanagementsystem.Controllers;


import com.example.librarymanagementsystem.Enums.Department;
import com.example.librarymanagementsystem.Models.Student;
import com.example.librarymanagementsystem.Services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){

        try{
            String result = studentService.addStudent(student);
            return new ResponseEntity(result,HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Student not added successfully {}",e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/findDeptById")
    public ResponseEntity findDeptById(@RequestParam("Id")Integer Id){

        try{
            Department department = studentService.getDepartmentById(Id);
            return new ResponseEntity(department,HttpStatus.OK);
        }catch (Exception e){
            log.error("Department not found/Invalid Request {}",e.getMessage());
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        }
    }
}
