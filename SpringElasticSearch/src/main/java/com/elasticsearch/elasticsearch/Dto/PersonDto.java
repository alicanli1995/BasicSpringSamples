package com.elasticsearch.elasticsearch.Dto;

import com.elasticsearch.elasticsearch.Entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonDto extends ElasticsearchRepository<Person,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"id\": \"?0\"}}]}}")
    List<Person> findByPerson(String  name);
}
