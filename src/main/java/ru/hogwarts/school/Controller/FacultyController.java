package ru.hogwarts.school.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.Service.FacultyService;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }
    @GetMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("color") String color){
        return facultyService.add(name, color);
    }
    @GetMapping("/find")
    public String get(@RequestParam("Id") long id){
        return facultyService.get(id);
    }
    @GetMapping("/update")
    public String update(@RequestParam("Id") long id, @RequestParam("new_name") String newname,
                         @RequestParam("new_color")String newcolor){
        return facultyService.update(id, newname, newcolor);
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("Id") long id){
        return facultyService.remove(id);
    }
    @GetMapping("/findbycolor")
    public String findByColor(String color){
        return facultyService.findByColor(color);
    }
}
