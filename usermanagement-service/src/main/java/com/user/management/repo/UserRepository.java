package com.user.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
