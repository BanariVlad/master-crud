package com.example.mastercrud.controller;

import com.example.mastercrud.model.User;
import com.example.mastercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user.
     *
     * @param newUser The user object to be created.
     * @return The created user.
     */
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    /**
     * Updates user information by ID.
     *
     * @param newUser The updated user information.
     * @param id      The ID of the user to be updated.
     * @return An optional containing the updated user if found, otherwise empty.
     */
    @PutMapping("/user/{id}")
    Optional<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());

                    return userRepository.save(user);
                });
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);

        return "User deleted";
    }
}
