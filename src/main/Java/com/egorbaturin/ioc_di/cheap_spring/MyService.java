package com.egorbaturin.ioc_di.cheap_spring;
@MyComponent
public class MyService {
    @RequestComponent
    private MyDependency myDependency;

    public void execute() {
        if (myDependency != null) {
            myDependency.doSomething();
        } else {
            System.out.println("Зависимость не внедрена");
        }
    }
}
