package com.example.consume.mapper.elasticsearch;

import com.example.commoncomponets.entity.consume.elasticsearch.Person;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 人员信息
 */
@Mapper
public interface PersonMapper extends ElasticsearchRepository<Person,Long> {

    Person queryPersonById(Long id);

    List<Person> findByName(String name);

    List<Person> findByNameAndWork(String name, String work);

    Page<Person> findByWork(String work, Pageable pageable);

}