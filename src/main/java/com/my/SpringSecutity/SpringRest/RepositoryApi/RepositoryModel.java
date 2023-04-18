package com.my.SpringSecutity.SpringRest.RepositoryApi;

import com.my.SpringSecutity.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryModel  extends JpaRepository<UserModels,Integer> {
}
