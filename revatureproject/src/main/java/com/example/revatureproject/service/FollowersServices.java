package com.example.revatureproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revatureproject.entity.Accounts;
import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Followers;
import com.example.revatureproject.entity.Posts;
import com.example.revatureproject.repository.*;

@Service
public class FollowersServices {
    FollowersRepository followersRepository;

    @Autowired
    public FollowersServices(FollowersRepository followersRepository){
        this.followersRepository = followersRepository;
    }

    public Followers addFollow(Followers followers){
        if(followers.getFollowedId() == null || followers.getFollowerId() == null){
            return null;
        }
        return followersRepository.save(followers);
    }

    public Followers getFollowersById(int FollowId){
        Optional<Followers> optionalFollowers = followersRepository.findById(FollowId);
        if (optionalFollowers.isPresent()){
            Followers follower = optionalFollowers.get();
            return follower;
        }
        else{
            return null;
        }
    }

    public int deleteFollow(int FollowId){
        if(getFollowersById(FollowId) != null){
            followersRepository.deleteById(FollowId);
            return 1;
        }
        else{
            return 0;
        }
    }

    public List<Followers> getAllFollows(){
        return (List<Followers>) followersRepository.findAll();
    }

    public List<Followers> getFollowersByFollowerId(int FollowerId){
        return followersRepository.findByFollowerId(FollowerId);
    }
}
