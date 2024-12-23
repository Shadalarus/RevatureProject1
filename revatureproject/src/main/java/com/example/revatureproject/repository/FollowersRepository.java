package com.example.revatureproject.repository;
import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Followers;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowersRepository extends JpaRepository<Followers, Integer> {
    List<Followers> findByFollowerId(Integer FollowerId);

}
