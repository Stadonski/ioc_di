package com.egorbaturin.ioc_di;

public class App {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);

        userService.registerUser("Ivan", "ivan2000@mail.ru");

        User user = userService.getUser("ivan2000@mail.ru");
        System.out.println("Полученный пользователь: " + user.getName() + ", Email: " + user.getEmail());
    }
}
