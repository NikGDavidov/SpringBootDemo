package ru.gb.demospringboot;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.web.bind.annotation.PutMapping;

//Создать Класс Student c полями: идентификатор, имя, имя группы
@Data
public class Student {
    private static long idCounter = 1L;

    private final long id;
    private String name;
    private String group;


    @JsonCreator
    public Student( long id,String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public Student(String name, String group) {
        this.id = idCounter++;
        this.name = name;
        this.group = group;
    }
}
