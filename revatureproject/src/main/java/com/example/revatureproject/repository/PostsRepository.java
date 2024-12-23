package com.example.revatureproject.repository;
import com.example.revatureproject.entity.Posts;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
    
    List<Posts> findByAccountId(Integer AccountId);

}
