package com.example.services;

import com.example.models.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public Optional<User> findById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    private Optional<User> findByName(String name) {
        return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()).isPresent();
    }

    public void deleteAllUsers() {
        users.clear();
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(), "Sam", 30, new BigDecimal("70000")));
        users.add(new User(UUID.randomUUID().toString(), "Tom", 40, new BigDecimal("50000")));
        users.add(new User(UUID.randomUUID().toString(), "Jerome", 45, new BigDecimal("30000")));
        users.add(new User(UUID.randomUUID().toString(), "Silvia", 50, new BigDecimal("40000")));
        return users;
    }

}

