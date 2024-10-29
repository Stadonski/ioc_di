package com.egorbaturin.ioc_di.cheap_spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**Аннотация для пометки классов как компонентов. Эти классы будут управляться нашим контейнером.**/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface MyComponent {
}
