package com.example.revatureproject.repository;
import com.example.revatureproject.entity.Comments;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    
    List<Comments> findByAccountId(Integer AccountId);

    List<Comments> findByPostId(Integer PostId);

}
