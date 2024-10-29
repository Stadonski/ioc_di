package com.egorbaturin.ioc_di.cheap_spring;

public class Main {

    public static void main(String[] args) {

        ComponentScanner componentScanner = new ComponentScanner();
        MyService myService = componentScanner.getBean(MyService.class);
        myService.execute();
    }
}
