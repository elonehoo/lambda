package com.inet;

import com.inet.codebase.entity.User;
import com.inet.codebase.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootTest

/**
 * Java7和Java8的特性对比
 * @author HCY
 * @since 2020-10-14
 */
class HcyApplicationTests {

    @Resource
    private UserService userService;

    /**
     * Java7和Java8进行排序
     */
    @Test
    void contextLoads() {
        //查找出所有
        List<User> list1 = userService.list();
        List<User> list2 = userService.list();

/*
//////////////////////////////////////////Java7语法///////////////////////////////////////////////////////////////////////////////
 */
        System.out.println("=====Java7排序方法=====");

        System.out.println("=====list1集合排序前=====");
        for (User user : list1 ) {
            System.out.println(user);
        }

        //排序的方法
        sortUsingJava7(list1);

        System.out.println("=====list1集合排序后=====");
        for (User user : list1 ) {
            System.out.println(user);
        }

/*
//////////////////////////////////////////Java8语法///////////////////////////////////////////////////////////////////////////////
 */

        System.out.println("=====Java8的lambda排序方法=====");

        System.out.println("=====list2集合排序前=====");
        list2.forEach(System.out::println);
        //排序的方法
        sortUsingJava8(list2);

        System.out.println("=====list2集合排序后=====");
        list2.forEach(System.out::println);
    }

    /**
     * Java7的排序匿名重写方式
     * @author HCY
     * @since 2020-10-14
     * @param list
     */
    private void sortUsingJava7(List<User> list){
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User s1, User s2) {
                return s1.getUserIdentity().compareTo(s2.getUserIdentity());
            }
        });
    }

    /**
     * Java8的lambda语法
     * @author HCY
     * @since 2020-10-14
     * @param list 集合参数
     */
    private void sortUsingJava8(List<User> list){
        Collections.sort(list, (s1, s2) -> s1.getUserIdentity().compareTo(s2.getUserIdentity()));
    }



}
