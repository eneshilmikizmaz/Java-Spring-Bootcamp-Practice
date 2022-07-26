package com.logo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.logo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
