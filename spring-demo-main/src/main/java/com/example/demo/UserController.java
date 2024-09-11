package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
public class UserController {
    private PollManager manager;

    public UserController(@Autowired PollManager manager) {
        this.manager = manager;
    }

    @GetMapping("/users")
    public Collection<User> getAllUsersHandler() {
        return manager.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserHandler(@PathVariable String id) {
        return ResponseEntity.ok().body(manager.getUser(id));
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUserHandler(@RequestBody User user) {
        manager.addUser(user);
        return ResponseEntity.created(URI.create("/users/" + user.getUsername())).body(user);
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<Object> deleteUserHandler(@RequestBody User user) {
        User userToRemove = manager.getUser(user.getUsername());
        manager.removeUser(userToRemove);
        return ResponseEntity.ok("Removed user");
    }


}
