package com.example.revatureproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.revatureproject.entity.Accounts;
import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Followers;
import com.example.revatureproject.entity.Friends;
import com.example.revatureproject.entity.Posts;

import com.example.revatureproject.service.*;

@RestController
public class ProjectController {
    
    AccountsService accountsService;
    PostsService postsService;
    CommentsService commentsService;
    FollowersServices followersServices;
    FriendsServices friendsServices;

    @Autowired
    public ProjectController(AccountsService accountsService, PostsService postsService, CommentsService commentsService, FollowersServices followersServices, FriendsServices friendsServices){
        this.accountsService = accountsService;
        this.postsService = postsService;
        this.commentsService = commentsService;
        this.followersServices = followersServices;
        this.friendsServices = friendsServices;
    }

    @PostMapping(value = "/register")
    @CrossOrigin
    public ResponseEntity<Accounts> newAccount(@RequestBody Accounts account){
        if(accountsService.addAccount(account) != null){
            return ResponseEntity.status(200).body(accountsService.addAccount(account));
        }
        else{
            if(accountsService.findAccountByUsername(account) != null){
                return ResponseEntity.status(409).body(null);
            }
            else{
                return ResponseEntity.status(400).body(null);
            }
        }
    }

    @PostMapping("/login/{username}/{password}")
    @CrossOrigin
    public ResponseEntity<Accounts> loginUser(@PathVariable String username, @PathVariable String password) {
        if(accountsService.loginAccount(username, password) != null){
            return ResponseEntity.status(200).body(accountsService.loginAccount(username, password));
        }
        else{
            return ResponseEntity.status(401).body(null);
        }
    }
    
    @PostMapping("/posts/newPost")
    @CrossOrigin
    public ResponseEntity<Posts> newPost(@RequestBody Posts post) {
        if(postsService.addPost(post) != null){
            return ResponseEntity.status(200).body(postsService.addPost(post));
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/users")
    @CrossOrigin
    public ResponseEntity<List<Accounts>> getAllUsers(){
        return ResponseEntity.status(200).body(accountsService.getAllAccounts());
    }

    @GetMapping(value = "/account/{AccountId}")
    @CrossOrigin
    public ResponseEntity<Accounts> getAccountById(@PathVariable int AccountId){
        return ResponseEntity.status(200).body(accountsService.getAccountById(AccountId));
    }

    @GetMapping(value = "/posts")
    @CrossOrigin
    public ResponseEntity<List<Posts>> getAllPosts(){
        return ResponseEntity.status(200).body(postsService.getAllPosts());
    }

    @GetMapping(value = "/posts/{PostId}")
    @CrossOrigin
    public ResponseEntity<Posts> getPostById(@PathVariable int PostId){
        return ResponseEntity.status(200).body(postsService.getPostById(PostId));
    }

    @DeleteMapping(value = "/posts/{PostId}")
    @CrossOrigin
    public ResponseEntity<Integer> deletePostById(@PathVariable int PostId){
        if(postsService.deletePost(PostId) == 1){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(200).body(null);
        }
    }

    @PatchMapping(value = "/posts/{PostId}")
    @CrossOrigin
    public ResponseEntity<Integer> updatePostById(@PathVariable int PostId, @RequestBody Posts post){
        if(postsService.updatePost(PostId, post) != null){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/accounts/{AccountId}/posts")
    @CrossOrigin
    public ResponseEntity<List<Posts>> getPostsByAccount(@PathVariable int AccountId){
        return ResponseEntity.status(200).body(postsService.getPostsByAccount(AccountId));
    }

    @PostMapping("/comments")
    @CrossOrigin
    public ResponseEntity<Comments> newComment(@RequestBody Comments comment) {
        if(commentsService.addComment(comment) != null){
            return ResponseEntity.status(200).body(commentsService.addComment(comment));
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/follow")
    @CrossOrigin
    public ResponseEntity<Followers> newFollow(@RequestBody Followers followers) {
        if(followersServices.addFollow(followers) != null){
            return ResponseEntity.status(200).body(followersServices.addFollow(followers));
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/follow/{accountId}")
    @CrossOrigin
    public ResponseEntity<List<Followers>> getFollowersByAccount(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(followersServices.getFollowersByFollowerId(accountId));
    }

    @DeleteMapping(value = "/stopFollow/{FollowId}")
    @CrossOrigin
    public ResponseEntity<Integer> deleteFollowById(@PathVariable int FollowId){
        if(followersServices.deleteFollow(FollowId) == 1){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(200).body(null);
        }
    }

    @PostMapping("/friend")
    @CrossOrigin
    public ResponseEntity<Friends> newFriend(@RequestBody Friends friend) {
        if(friendsServices.addFriend(friend) != null){
            return ResponseEntity.status(200).body(friendsServices.addFriend(friend));
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/friends/{accountId}")
    @CrossOrigin
    public ResponseEntity<List<Friends>> getFriendsByAccount(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(friendsServices.getFriendsBySentByAndAccepted(accountId, 1));
    }

    @GetMapping("/pending/{accountId}")
    @CrossOrigin
    public ResponseEntity<List<Friends>> getPendingFriends(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(friendsServices.getFriendsByReceivedByAndAccepted(accountId, 0));
    }

    @GetMapping("/acceptedFriends/{accountId}")
    @CrossOrigin
    public ResponseEntity<List<Friends>> getAcceptedFriends(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(friendsServices.getFriendsByReceivedByAndAccepted(accountId, 1));
    }

    @DeleteMapping(value = "/stopFriend/{FriendId}")
    @CrossOrigin
    public ResponseEntity<Integer> deleteFriendById(@PathVariable int FriendId){
        if(friendsServices.deleteFriend(FriendId) == 1){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(200).body(null);
        }
    }

    @GetMapping(value = "/comments/{CommentId}")
    @CrossOrigin
    public ResponseEntity<Comments> getCommentById(@PathVariable int CommentId){
        return ResponseEntity.status(200).body(commentsService.getCommentsById(CommentId));
    }

    @DeleteMapping(value = "/comments/{CommentId}")
    @CrossOrigin
    public ResponseEntity<Integer> deleteCommentById(@PathVariable int CommentId){
        if(commentsService.deleteComment(CommentId) == 1){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(200).body(null);
        }
    }

    @PatchMapping(value = "/comments/{CommentId}")
    @CrossOrigin
    public ResponseEntity<Integer> updateCommentById(@PathVariable int CommentId, @RequestBody Comments comment){
        if(commentsService.updateComment(CommentId, comment) != null){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping(value = "/accounts/{AccountId}/comments")
    @CrossOrigin
    public ResponseEntity<List<Comments>> getCommentsByAccount(@PathVariable int AccountId){
        return ResponseEntity.status(200).body(commentsService.getCommentsByAccount(AccountId));
    }

    @GetMapping(value = "/posts/{PostId}/comments")
    @CrossOrigin
    public ResponseEntity<List<Comments>> getCommentsByPost(@PathVariable int PostId){
        return ResponseEntity.status(200).body(commentsService.getCommentsByPost(PostId));
    }


    @PatchMapping(value = "/updateEmail/{accountId}/{email}")
    @CrossOrigin
    public ResponseEntity<Integer> updateEmail(@PathVariable int accountId, @PathVariable String email){
        if(accountsService.updateEmail(accountId, email) != null){
            return ResponseEntity.status(200).body(1);
        }
        else{
            return ResponseEntity.status(400).body(null);
        }
    }
}
