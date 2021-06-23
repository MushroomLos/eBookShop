package com.example.demoentity.entity;

/**
 * @author xuzihan
 * @version 1.0
 * @description: TODO
 * @data
 **/

public class Consumer {
    private String name;
    private int age;
    private String add;
    private String email;

    public Consumer() {
        this.name = "name";
        this.age = 12;
        this.add = "北京市历史互通";
        this.email = "6666.qq.com";
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", add='" + add + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
