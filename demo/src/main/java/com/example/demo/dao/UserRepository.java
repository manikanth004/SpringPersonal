package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
