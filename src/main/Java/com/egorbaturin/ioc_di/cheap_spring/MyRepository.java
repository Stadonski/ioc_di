package com.egorbaturin.ioc_di.cheap_spring;

@MyComponent
public class MyRepository {
    public void doSomething() {
        System.out.println("Что то делаю в контейнере");
    }
}
