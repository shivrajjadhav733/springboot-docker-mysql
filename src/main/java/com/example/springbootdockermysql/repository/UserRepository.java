package com.example.springbootdockermysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootdockermysql.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
