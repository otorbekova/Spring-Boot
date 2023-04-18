package com.my.SpringSecutity.Repository;

import com.my.SpringSecutity.models.UserModels;
//import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModels, Integer> {
    Optional<UserModels> findByUserName(String s);
}
