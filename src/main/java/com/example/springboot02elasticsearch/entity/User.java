package com.example.springboot02elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "surName",type = FieldType.Text)
    private String surName;
    @Field(name = "address",type = FieldType.Text)
    private String address;
    @Field(name = "birthday",type = FieldType.Text)
    private Date birthday;

}
