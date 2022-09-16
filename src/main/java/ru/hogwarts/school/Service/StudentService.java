package ru.hogwarts.school.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;
import java.util.HashMap;
@Service
public class StudentService {
    private HashMap<Long, Student> students = new HashMap<>();
    private long id = 0;

    public ResponseEntity add(Student student){
        id++;
        return students.put(id, new Student(id, name, age));
    }
    public String get(long id){
        return students.get(id).toString();
    }
    public String update(long id, String newName, int newAge){
        Student studentToUpdate = students.get(id);
        String studentCredentials = students.get(id).toString();
        studentToUpdate.setName(newName);
        studentToUpdate.setAge(newAge);
        students.put(id,studentToUpdate);
        return "Credentials of " + studentCredentials + " were updated to " + studentToUpdate;
    }
    public String remove(long id){
        return students.remove(id).toString();
    }

    public String findByAge(int age) {
        for (long i = 0; i < students.size(); i++) {
            if(students.containsKey(i)&&students.get(i).getAge()==age)
                return students.get(i).toString();
        }
        return "Search complete.";
    }

}
