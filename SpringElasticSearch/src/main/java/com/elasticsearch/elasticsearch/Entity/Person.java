package com.elasticsearch.elasticsearch.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "last_name",type = FieldType.Text)
    private String lastName;
    @Field(name = "address",type = FieldType.Text)
    private String address;
    @Field(name = "name",type = FieldType.Date)
    private Date birthYear;

}
