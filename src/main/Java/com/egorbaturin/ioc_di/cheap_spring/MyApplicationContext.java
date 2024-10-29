package com.egorbaturin.ioc_di.cheap_spring;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyApplicationContext {

    private Map<Class<?>, Object> beans = new HashMap<>();

    public MyApplicationContext(String packageName) {
        scanBeans(packageName);
        injectDependencies();
    }

    private void scanBeans(String packageName) {

        registerBean(MyService.class);
        registerBean(MyRepository.class);
    }

    private void registerBean(Class<?> clazz) {
        if (clazz.isAnnotationPresent(MyComponent.class)) {
            try {
                beans.put(clazz, clazz.getDeclaredConstructor().newInstance());
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
                    Class<?> dependencyType = field.getType();
                    Object dependency = beans.get(dependencyType);
                    if (dependency != null) {
                        field.setAccessible(true);
                        try {
                            field.set(bean, dependency);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }
}
