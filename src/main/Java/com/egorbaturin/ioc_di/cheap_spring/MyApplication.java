package com.egorbaturin.ioc_di.cheap_spring;

public class MyApplication {
    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext("com.example");

        MyService myService = context.getBean(MyService.class);
        myService.performAction();
    }
}
