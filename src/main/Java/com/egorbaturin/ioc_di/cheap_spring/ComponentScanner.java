package com.egorbaturin.ioc_di.cheap_spring;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ComponentScanner {
    private Map<Class<?>, Object> beans = new HashMap<>();

    public ComponentScanner() {
        registerBean(MyDependency.class);
        registerBean(MyService.class);
        injectDependencies();
    }

    private void registerBean(Class<?> clazz) {
        try {
            beans.put(clazz, clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void injectDependencies() {
        for (Object bean : beans.values()) {
            Class<?> clazz = bean.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(RequestComponent.class)) {
                    field.setAccessible(true);
                    try {
                        Object dependency = beans.get(field.getType());
                        if (dependency != null) {
                            field.set(bean, dependency);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(beans.get(clazz));
    }
}
