package com.Safar.fullstackbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Safar.fullstackbackend.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
