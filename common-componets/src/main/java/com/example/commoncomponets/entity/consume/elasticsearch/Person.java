package com.example.commoncomponets.entity.consume.elasticsearch;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@ApiModel(value = "人员信息")
@Document(indexName="es_person",type="person")
public class Person {

    @ApiModelProperty(value = "id", example = "1", required = true)
    @Id
    private Long id;

    @ApiModelProperty(value = "名称", example = "1", required = true)
    @Field(type = FieldType.Keyword)
    private String name;

    @ApiModelProperty(value = "年龄", example = "1", required = true)
    private Integer age;

    @ApiModelProperty(value = "工作", example = "1", required = true)
    private String work;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Person() {
        super();
    }

    public Person(Long id, String name, Integer age, String work) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.work = work;
    }

}