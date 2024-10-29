package com.egorbaturin.ioc_di;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
