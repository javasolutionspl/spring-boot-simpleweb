package net.effectivecode.controller;

import java.util.Set;
import net.effectivecode.entity.User;
import net.effectivecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserWebService {

    private UserService userService;

    @Autowired
    public UserWebService(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Set<User>> getAllUsers() {

        Set<User> found = userService.findAll();
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {

        User found = userService.findById(id);
        if (null == found) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<User> updateUserName(@RequestBody User user) {

        userService.updateUserName(user.getId(), user.getUserName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {

        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(String id) {

        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create/{userName}")
    public ResponseEntity<User> create(@PathVariable("userName") String userName) {

        userService.create(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
