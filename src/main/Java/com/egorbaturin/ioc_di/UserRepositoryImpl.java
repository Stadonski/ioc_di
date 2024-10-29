package com.egorbaturin.ioc_di;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{

    private Map<String, User> userDatabase = new HashMap<>();

    @Override
    public void save(User user) {
        userDatabase.put(user.getEmail(), user);
        System.out.println("User saved: " + user.getName());
    }

    @Override
    public User findByEmail(String email) {
        return userDatabase.get(email);
    }
}
