package ru.hogwarts.school.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private HashMap<Long, Student> students = new HashMap<>();
    private long id = 0;
    public Student add(Student student) {
        student.setId(++id);
        students.put(id, student);
        return student;
    }
    public Student get(long id) {
        return students.get(id);
    }
    public Collection<Student> filterByAge(int age) {
        List<Student> tempCollection = new ArrayList<>(students.values()) ;
        for (int i = 0; i < tempCollection.size(); i++) {
          if (tempCollection.get(i).getAge() != age){
              tempCollection.remove(i);
          }
        }
        return tempCollection;
    }
    public Student update(Student student) {
        if(students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return  student;
        }
        return null;
    }

    public Student remove(long id) {
        return students.remove(id);
    }
}
