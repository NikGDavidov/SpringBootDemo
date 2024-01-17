package ru.gb.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

     //* 3.1 GET /students/{id} - получить студента по ID
    @GetMapping( "/{id}")
    public Student getStudent(@PathVariable long id) {
        return repository.getById(id);
    }

    //* 3.2 GET /students - получить всех студентов
   // @RequestMapping(path = "/students", method = RequestMethod.GET)т
    @GetMapping("/")
    public List getStudents(){
             return repository.getAll();
    }

    //* 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя
    // содержит подстроку studentName
    @GetMapping
    public Student getStudentByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    //* 3.4 GET /group/{groupName}/student - получить всех студентов группы
    @GetMapping ("/group/{groupName}/student")
    public List getStudentsFromGroup(@PathVariable String group){
        return repository.getByGroup(group);
    }

        // * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
    @PostMapping("/student")
    public Student addStudent (@RequestBody Student student){
        repository.addStudent(student);
        List<Student> list = repository.getAll();
        return list.get(list.size()-1);
    }
    //* 3.6 DELETE /student/{id} - удалить студента
    @DeleteMapping( "/student/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
       final boolean deleted = repository.deleteStudent(id);

        return deleted
              ? new ResponseEntity<>(HttpStatus.OK)
              : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
   
}
