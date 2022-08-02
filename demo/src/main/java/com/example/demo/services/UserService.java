package com.example.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;



@Service
public class UserService 
{
	
	@Autowired
    private UserRepository userRepository;
//For add User to DataBase
    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    //For Adding multiple Users
    public List<User> createUsers(List<User> user)
    {
        return userRepository.saveAll(user);
    }
//    Get User by ID
    public User getById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }
//    Get All Users
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
//    Update the User by id
    public User updateUser(User user)
    {
        Optional<User> optionalUser;
        optionalUser = userRepository.findById(user.getId());

        if(optionalUser.isPresent())
        {
         User oldUser=   optionalUser.get();
         oldUser.setMail(user.getMail());
         oldUser.setName(user.getName());
         userRepository.save(oldUser);
//        Check Here if any error occur
         return oldUser;

        }
        else
        {
            return new User();

        }

    }

    public User updateById(int id)
    {
        Optional<User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            User oldUser=optionalUser.get();
            oldUser.setName(oldUser.getName());
            oldUser.setMail(oldUser.getMail());
            userRepository.save(oldUser);
            return oldUser;

        }
        else {
            return new User();
        }
    }

//    Delete User
    public String deleteUser(int id)
    {
        userRepository.deleteById(id);
        return "Deleted User";
    }



}
