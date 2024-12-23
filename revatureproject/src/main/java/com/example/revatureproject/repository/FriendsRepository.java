package com.example.revatureproject.repository;
import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Followers;
import com.example.revatureproject.entity.Friends;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {
    List<Friends> findBySentBy(Integer sentBy);
    List<Friends> findByReceivedBy(Integer receivedBy);
    List<Friends> findByReceivedByAndAccepted(Integer receivedBy, Integer accepted);
    List<Friends> findBySentByAndAccepted(Integer sentBy, Integer accepted);
}
