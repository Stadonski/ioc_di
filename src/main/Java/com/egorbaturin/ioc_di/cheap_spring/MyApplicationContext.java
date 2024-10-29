package com.egorbaturin.ioc_di.cheap_spring;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyApplicationContext {
    private Map<Class<?>, Object> beans = new HashMap<>();

    public MyApplicationContext(String packageName) {
        scanBeans(packageName);
        injectDependencies();
    }

    private void scanBeans(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(MyComponent.class);

        for (Class<?> clazz : annotatedClasses) {
            try {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beans.put(clazz, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void injectDependencies() {
        for (Object bean : beans.values()) {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(RequestComponent.class)) {
                    field.setAccessible(true); // Делаем поле доступным
                    try {
                        Class<?> fieldType = field.getType();
                        Object dependency = beans.get(fieldType);
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

    public <T> T getBean(Class<T> beanClass) {
        return (T) beans.get(beanClass);
    }
}
