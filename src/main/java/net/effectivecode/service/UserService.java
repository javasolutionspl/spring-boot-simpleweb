package net.effectivecode.service;

import java.util.HashSet;
import java.util.Set;
import net.effectivecode.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private Set<User> storedUsers;

    public UserService() {

        storedUsers = new HashSet<>();
    }

    public void create(String userName) {

        User newUser = new User(String.valueOf(storedUsers.size()), userName);
        storedUsers.add(newUser);
    }

    public User findById(String id) {

        return storedUsers.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElse(null);
    }

    public Set<User> findAll() {

        return storedUsers;
    }

    public void delete(String id) {

        User found = findById(id);
        storedUsers.remove(found);
    }

    public void update(User user) {

        User toUpdate = findById(user.getId());
        storedUsers.remove(toUpdate);
        storedUsers.add(user);
    }

    public void updateUserName(String userId, String userName) {

        User toUpdate = findById(userId);
        toUpdate.setUserName(userName);
    }
}
