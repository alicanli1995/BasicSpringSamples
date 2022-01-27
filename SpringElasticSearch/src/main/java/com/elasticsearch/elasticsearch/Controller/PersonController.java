package com.elasticsearch.elasticsearch.Controller;


import com.elasticsearch.elasticsearch.Dto.PersonDto;
import com.elasticsearch.elasticsearch.Entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonDto personDto;
    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setName("Test");
        person.setLastName("ElasticSearch");
        person.setAddress("Test Address");
        person.setBirthYear(Calendar.getInstance().getTime());
        person.setId("P01");
        personDto.save(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Person>> listResponseEntity(@PathVariable String id){
        List<Person>  personList = personDto.findByPerson(id);
        return ResponseEntity.ok(personList);
    }


}
