package com.sergiolopezmi.apitiempo.repositories;

import com.sergiolopezmi.apitiempo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT U.id, U.name, R.roleName FROM User U INNER JOIN Role R ON U.role = R.id")
    List<User> findAllUsers();
}
