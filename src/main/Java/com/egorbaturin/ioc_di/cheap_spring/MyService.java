package com.egorbaturin.ioc_di.cheap_spring;
@MyComponent
public class MyService {
    @RequestComponent
    private MyRepository myRepository;

    public void performAction() {
        myRepository.doSomething();
    }
}
