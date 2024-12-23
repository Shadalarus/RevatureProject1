package com.example.revatureproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revatureproject.entity.Comments;
import com.example.revatureproject.entity.Posts;
import com.example.revatureproject.repository.*;

@Service
public class CommentsService {
    
    CommentsRepository commentsRepository;
    AccountsRepository accountsRepository;
    PostsRepository postsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository, AccountsRepository accountsRepository, PostsRepository postsRepository){
        this.postsRepository = postsRepository;
        this.accountsRepository = accountsRepository;
        this.commentsRepository = commentsRepository;
    }

    public Comments addComment(Comments comment){
        if(comment.getCommentText().length() > 255 || comment.getCommentText() == "" || accountsRepository.findById(comment.getAccountId()).isPresent() == false || postsRepository.findById(comment.getPostId()).isPresent() == false){
            return null;
        }
        return commentsRepository.save(comment);
    }

    public Comments getCommentsById(int CommentId){
        Optional<Comments> optionalComment = commentsRepository.findById(CommentId);
        if (optionalComment.isPresent()){
            Comments comment = optionalComment.get();
            return comment;
        }
        else{
            return null;
        }
    }

    public int deleteComment(int CommentId){
        if(getCommentsById(CommentId) != null){
            commentsRepository.deleteById(CommentId);
            return 1;
        }
        else{
            return 0;
        }
    }

    public Comments updateComment(int CommentId, Comments comment){
        if(comment.getCommentText().length() > 255 || comment.getCommentText() == ""){
            return null;
        }
        Optional<Comments> optionalComment = commentsRepository.findById(CommentId);
        if (optionalComment.isPresent()){
            Comments newComment = optionalComment.get();
            newComment.setCommentText(comment.getCommentText());
            return commentsRepository.save(newComment);
        }
        else{
            return null;
        }
    }

    public Comments updateCommentLikes(int CommentId, Comments comment){
        Optional<Comments> optionalComment = commentsRepository.findById(CommentId);
        if (optionalComment.isPresent()){
            Comments newComment = optionalComment.get();
            newComment.setCommentLikes(comment.getCommentLikes());
            return commentsRepository.save(newComment);
        }
        else{
            return null;
        }
    }

    public List<Comments> getCommentsByAccount(int AccountId){
        return commentsRepository.findByAccountId(AccountId);
    }

    public List<Comments> getCommentsByPost(int PostId){
        return commentsRepository.findByPostId(PostId);
    }

}
