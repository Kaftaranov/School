package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import java.util.HashMap;

@Service
public class FacultyService {
    HashMap<Long, Faculty> faculties = new HashMap<>();
    long id = 0;

    public String add(String name, String color){
       id++;
       faculties.put(id, new Faculty(id,name,color));
       return faculties.get(id).toString() + " was successfully added.";
    }
    public String get(long id){
        return faculties.get(id).toString();
    }
    public String update(long id, String newName, String newColor){
        Faculty facultyToUpdate = faculties.get(id);
        String dataToUpdate = facultyToUpdate.toString();
        facultyToUpdate.setColor(newColor);
        facultyToUpdate.setName(newName);
        return "Credentials of " + dataToUpdate + " were updated to "+ facultyToUpdate;
    }
    public String remove(long id){
        faculties.remove(id);
        return faculties.remove(id).toString() + " was removed.";
    }

    public String findByColor(String color) {
        for (long i = 0; i < faculties.size(); i++) {
            if(faculties.containsKey(i)&&faculties.get(i).getColor().equals(color))
                return faculties.get(i).toString();
        }
        return "Search complete.";
    }
}
