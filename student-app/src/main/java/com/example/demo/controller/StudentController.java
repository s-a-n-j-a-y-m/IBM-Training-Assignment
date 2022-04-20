package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAllStudents(Model model)
    {
        List<Student> list=studentService.getAllStudent();
        model.addAttribute("students",list);
        return "student-list";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
    	Student theStudent =new Student();
    	theModel.addAttribute("student",theStudent);
    	return "student-form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute("student")Student student)
    {
    	Student c=studentService.createStudent(student);
    	System.out.println(c);
    	return "redirect:/students/list";
    }
    @GetMapping("/delete")
    public String deleById(@RequestParam("id")int id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForEdit(@RequestParam("id")int id,Model theModel)
    {
    	Student theStudent =studentService.getStudent(id);
    	theModel.addAttribute("student",theStudent);
    	return "student-form";
    }
    
}