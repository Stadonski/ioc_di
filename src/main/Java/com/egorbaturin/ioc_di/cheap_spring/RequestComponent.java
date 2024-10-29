package com.egorbaturin.ioc_di.cheap_spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**Аннотация для пометки полей, в которые необходимо внедрять зависимости.**/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface RequestComponent {
}
