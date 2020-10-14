# Lambda 食用方式

### 介绍

**_Lambda 表达式 , 也可以称之为`闭包` ,是Java8发布的最重要的新特性_**

**_Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。_**

### 语法

` (parameters) -> expression`

`(parameters) ->{ statements; }`

### 重要特性

**_可选的类型声明 : 不需要声明参数类型,编译器可以统一识别参数值_**

**_可选的参数圆括号`()` : 一个参数无需定义圆括号,但多个参数需要定义圆括号_**

**_可选的大括号 `{}` : 如果主题包含了一个语句,就不需要大括号_**

**_可选的返回关键字 : 如果主题只有一个返回式返回值,则编译器会自动返回,大括号需要指定表达式返回了一个数值_**

### 简单的实例

```java
// 1. 不需要参数,返回值为 5  
() -> 5  
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

### 更进一步的食用攻略 特性和语法进行比较

```java
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

```

### 括号的使用,和返回值的使用

```java
package com.inet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * HcyApplicationTest
 *
 * @author HCY
 * @since 2020/10/14
 */
@SpringBootTest
public class HcyApplicationTest {


    /**
     * 简单的小例子
     * @author HCY
     * @since 2020-10-14
     */
    @Test
    void contextLoads() {

        HcyApplicationTest tester = new HcyApplicationTest();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("hai " + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("HCY");
        greetService2.sayMessage("HCY");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
```

## 说明

```markdown
# 说明
### Lambda 允许吧函数作为一个方法的参数 (函数作为参数传递到方法中)
### Java 8 希望有自己的编程风格，并与 Java 7 区别开.
```

### 优缺点

```markdown
# 优点
## 少量的代码就能替代以前的一大堆循环判断过滤等，代码简洁。

# 缺点
## 用Lambda充当匿名内部类、方法引用等场合效率低。
## Lambda的特点还在于开发成本高，并且异常难以排查。它的异常堆栈比匿名内部类还要难懂。如果你把stream的操作都写在同一行，则问题更甚。
## 代码维护性差。
```
