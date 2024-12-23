package com.example.revatureproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revatureproject.entity.Accounts;
import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Followers;
import com.example.revatureproject.entity.Friends;
import com.example.revatureproject.entity.Posts;
import com.example.revatureproject.repository.*;

@Service
public class FriendsServices {
    FriendsRepository friendsRepository;

    @Autowired
    public FriendsServices(FriendsRepository friendsRepository){
        this.friendsRepository = friendsRepository;
    }

    public Friends addFriend(Friends friends){
        if(friends.getReceivedBy() == null || friends.getSentBy() == null){
            return null;
        }
        return friendsRepository.save(friends);
    }

    public Friends getFriendsById(int FriendId){
        Optional<Friends> optionalFriends = friendsRepository.findById(FriendId);
        if (optionalFriends.isPresent()){
            Friends friend = optionalFriends.get();
            return friend;
        }
        else{
            return null;
        }
    }

    public int deleteFriend(int FriendId){
        if(getFriendsById(FriendId) != null){
            friendsRepository.deleteById(FriendId);
            return 1;
        }
        else{
            return 0;
        }
    }

    public List<Friends> getAllFriends(){
        return (List<Friends>) friendsRepository.findAll();
    }

    public List<Friends> getFriendsBySentBy(int FriendId){
        return friendsRepository.findBySentBy(FriendId);
    }

    public List<Friends> getFriendsByReceivedBy(int FriendId){
        return friendsRepository.findByReceivedBy(FriendId);
    }

    public List<Friends> getFriendsByReceivedByAndAccepted(int FriendId, int accepted){
        return friendsRepository.findByReceivedByAndAccepted(FriendId, accepted);
    }

    public List<Friends> getFriendsBySentByAndAccepted(int FriendId, int accepted){
        return friendsRepository.findBySentByAndAccepted(FriendId, accepted);
    }
}
