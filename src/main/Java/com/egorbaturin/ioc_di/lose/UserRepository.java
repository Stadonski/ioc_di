package com.egorbaturin.ioc_di.lose;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
