package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {
    HashMap<Long, Faculty> faculties = new HashMap<>();
    long id = 0;

    public Faculty add(Faculty faculty){
       faculty.setId(++id);
       faculties.put(id, faculty);
       return faculty;
    }
    public Faculty get(long id){
        return faculties.get(id);
    }
    public Collection<Faculty> filterByColor(String color) {
        List<Faculty> tempCollection = new ArrayList<>(faculties.values()) ;
        for (int i = 0; i < tempCollection.size(); i++) {
            if (!tempCollection.get(i).getColor().equals(color)){
                tempCollection.remove(i);
            }
        }
        return tempCollection;
    }
    public Faculty update(Faculty faculty){
        if(faculties.containsKey(id)){
            faculties.put(faculty.getId(),faculty);
            return faculty;
        }
        return null;
    }

    public Faculty remove(long id){
        return faculties.remove(id);
    }

}
