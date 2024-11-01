package com.liucc;

import io.github.linpeilie.Converter;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;

/**
 * @ClassName: MapStructTest
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2024/11/1 17:11
 * @version: V1.0
 */
public class MapStructTest {
    private static Converter converter = new Converter();

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        UserDto convert = converter.convert(user, UserDto.class);
        System.out.println(convert);
    }
}

@AutoMapper(target = UserDto.class)
class User {
    @AutoMapping(target = "userName", source = "name")
    private String name;
    @AutoMapping(target = "userAge", source = "age")
    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class UserDto {
    private String userName;
    private int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}

