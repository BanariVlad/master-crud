package com.example.mastercrud.repository;

import com.example.mastercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

}
