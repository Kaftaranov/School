package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Student student){
        return  studentService.add(student);
    }
    @GetMapping({"id"})
    public ResponseEntity find (@PathVariable long id){
        return studentService.get(id);
    }
    @GetMapping({"age"})
    public ResponseEntity findByAge(int age){
        return studentService.findByAge(age);
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestParam("Id") long id, @RequestParam("new_name") String newName,
                         @RequestParam("new_age") int newAge){
        return studentService.update(id, newName,newAge);
    }
    @DeleteMapping ("/remove")
    public String remove(@RequestParam("Id") long id){
        return studentService.remove(id);
    }
}
