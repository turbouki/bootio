package com.example.bootio.app.repository;

import com.example.bootio.app.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Usr, Long> {
//    String query = "SELECT user_id, first_name, last_name, password, role_name FROM usr";
//    @Query(query)
    List<Usr> findAll();
}
