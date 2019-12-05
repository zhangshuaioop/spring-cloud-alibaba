package com.example.consume.service;

import com.example.commoncomponets.entity.consume.elasticsearch.Person;
import com.example.commoncomponets.utils.Result;
import com.example.commoncomponets.utils.ResultUtil;
import com.example.consume.mapper.elasticsearch.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description: 人员信息
 * @author: zhangshuai
 * @create: 2019-11-08 10:42
 */
@Service
public class PersonService {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private PersonMapper personMapper;


    //单数据保存
    public void save(){
        Person p = new Person(1L,"jack",18,"worker");
        personMapper.save(p);
    }

    //多数据批量保存
    public void saveAll(){
        /*Person p2 = new Person(3L,"alice",15,"student");
        Person p3 = new Person(4L,"kotlin",20,"teacher");*/

        List<Person> personList = new ArrayList<>();
        /*personList.add(p2);
        personList.add(p3);*/

        for (int i = 5; i<10; i++){
            long id = (long)i;
            Person p= new Person(id ,"jason",16+i,"programmer");
            personList.add(p);
        }

        personMapper.saveAll(personList);

    }

    //更新数据
    public void update(){
        Person person =  personMapper.queryPersonById(5L);
        System.out.println(person);
        person.setName("Ehson");
        person.setAge(30);
        person.setWork("architects");
        personMapper.save(person);
        System.out.println(personMapper.queryPersonById(5L));
    }

    //根据id查询
    public void findById(){
        Optional<Person> p = personMapper.findById(1L);
        System.out.println(p);
    }

    //根据name查询
    public void findByName(){
        for(Person p: personMapper.findByName("jason")){
            System.out.println(p);
        }
    }

    //查出所有
    public Result findAll() {
        for(Person p: personMapper.findAll()){
            System.out.println(p);
        }

        return ResultUtil.success(personMapper.findAll());
    }

    //根据name work查询
    public void findByNameAndWork(){
        for(Person p: personMapper.findByNameAndWork("jason","programmer")){
            System.out.println(p);
        }
    }

    //分页查询
    public Result findPage(Person person){
        // 分页参数:分页从0开始，age倒序
        Pageable pageable = new PageRequest(0, 5, Sort.Direction.DESC,"age");
        Page<Person> pageageRsutl = personMapper.findByWork("fdsf",pageable);
        System.out.println("总页数"+pageageRsutl.getTotalPages());
        List<Person> personList= pageageRsutl.getContent();//结果
        return ResultUtil.success(personList);
    }

    //自定义查询
//    public void etmTest() {
//        //查询关键字
//        String word="jason";
//
//        // 分页设置,age倒序
//        Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC,"age");
//
//        SearchQuery searchQuery;
//
//        //0.使用queryStringQuery完成单字符串查询queryStringQuery("name", "work")
//        //1.multiMatchQuery多个字段匹配 .operator(MatchQueryBuilder.Operator.AND)多项匹配使用and查询即完全匹配都存在才查出来
//        searchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQuery(word, "name", "work").operator(Operator.AND)).withPageable(pageable).build();
//
//        //2.多条件查询：name和work必须包含word=“XXX”且age必须大于21的以age倒序分页结果
//        word="programmer";
//        searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery().must(multiMatchQuery(word, "name", "work").operator(Operator.AND)).must(rangeQuery("age").gt(21))).withPageable(pageable).build();
//
//        List<Person> list= elasticsearchTemplate.queryForList(searchQuery, Person.class);
//        for (Person person : list) {
//            System.out.println(person);
//        }
//    }

    //删除所有
    public Result deleteAll(){
        //1. 第一种
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.setIndex("person_index");
        deleteQuery.setType("person");
        elasticsearchTemplate.delete(deleteQuery);
        //2. 第二种
        //personMapper.deleteAll();

        return ResultUtil.success();
    }

    //根据id删除
    public void deleteById(){
        for(Person p: personMapper.findAll()){
            System.out.println(p);
        }
        personMapper.deleteById(1L);
        for(Person p: personMapper.findAll()){
            System.out.println("******"+p);
        }
    }


    //记数
    public void count(){
        long count = personMapper.count();
        System.out.println(count);
    }

}
