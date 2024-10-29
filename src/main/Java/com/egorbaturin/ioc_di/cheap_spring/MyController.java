package com.egorbaturin.ioc_di.cheap_spring;
@MyComponent
public class MyController {

    @RequestComponent
    private MyService myService;

    public void process(){
        myService.doSomething();
    }
}
