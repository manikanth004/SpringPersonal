package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.model.User;
import com.example.demo.services.UserService;



@RestController
public class UserController
{
	
	@Autowired
    private UserService userService;

    @GetMapping("/Home")
    public String home()
    {
        return "Welcome to Home";
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.createUser(user);

    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> user)
    {
        return userService.createUsers(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id)
    {
        return userService.getById(id);

    }

    @GetMapping("/getUsers")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @PatchMapping("/update/{id}")
    public User updateById(@RequestBody int id)
    {
        return userService.updateById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id)
    {
        return userService.deleteUser(id);

    }


}
