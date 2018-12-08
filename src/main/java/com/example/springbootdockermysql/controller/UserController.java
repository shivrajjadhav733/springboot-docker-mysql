package com.example.springbootdockermysql.controller;

import com.example.springbootdockermysql.entity.User;
import com.example.springbootdockermysql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }
    
    @GetMapping("/create")
    public List<User> users() {
        User users = new User();
        users.setId(new Long(1));
        users.setName("Sam");
        users.setCountry("Development");

        userRepository.save(users);

        return userRepository.findAll();
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject)
    {
        User user = userRepository.findById(userId).get();
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    @ResponseBody
    public User findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findById(userId).get();
    }
}
