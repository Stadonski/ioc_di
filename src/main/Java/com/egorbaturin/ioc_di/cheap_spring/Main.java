package com.egorbaturin.ioc_di.cheap_spring;

public class Main {
    public static void main(String[] args) {

        MyApplicationContext context = new MyApplicationContext("com.egorbaturin.ioc_di.cheap_spring");
        MyController controller = (MyController) context.getBean(MyController.class);
        controller.process();
    }
}
