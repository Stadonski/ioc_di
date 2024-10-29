package com.egorbaturin.ioc_di.lose;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
    }
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
