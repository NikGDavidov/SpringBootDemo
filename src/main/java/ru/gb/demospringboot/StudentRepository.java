package ru.gb.demospringboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
@Component
public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    public StudentRepository(){
        Student ivan = new Student("Ivan", "M8");
        Student petr = new Student("Petr", "M12");
        Student fedor = new Student("Fedor", "M8");
        Student anton = new Student("Anton","M12");
        Student stepan = new Student("Stepan","M9");
     Collections.addAll(students, ivan,petr,fedor,anton, stepan);
    }
    public List<Student> getAll() {
        return List.copyOf(students);
    }
    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }
    public List <Student> getByGroup (String group){
        return students.stream().filter(it ->Objects.equals(it.getGroup(), group)).toList();
    }

    public void addStudent (Student student){
        students.add(student);
    }

    public boolean deleteStudent(long id){
      return students.remove(this.getById(id));
    }

}
