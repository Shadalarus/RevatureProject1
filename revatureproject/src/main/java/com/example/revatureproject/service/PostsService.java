package com.example.revatureproject.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.revatureproject.entity.Posts;
import com.example.revatureproject.repository.AccountsRepository;
import com.example.revatureproject.repository.PostsRepository;

@Service
public class PostsService {
    
    PostsRepository postsRepository;
    AccountsRepository accountsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository, AccountsRepository accountsRepository){
        this.postsRepository = postsRepository;
        this.accountsRepository = accountsRepository;
    }

    public Posts addPost(Posts post){
        if(post.getMessageText().length() > 255 || post.getMessageText() == "" || accountsRepository.findById(post.getAccountId()).isPresent() == false){
            return null;
        }
        return postsRepository.save(post);
    }

    public List<Posts> getAllPosts(){
        return (List<Posts>) postsRepository.findAll();
    }

    public Posts getPostById(int PostId){
        Optional<Posts> optionalPost = postsRepository.findById(PostId);
        if (optionalPost.isPresent()){
            Posts post = optionalPost.get();
            return post;
        }
        else{
            return null;
        }
    }

    public int deletePost(int PostId){
        if(getPostById(PostId) != null){
            postsRepository.deleteById(PostId);
            return 1;
        }
        else{
            return 0;
        }
    }

    public Posts updatePost(int PostId, Posts post){
        if(post.getMessageText().length() > 255 || post.getMessageText() == ""){
            return null;
        }
        Optional<Posts> optionalPost = postsRepository.findById(PostId);
        if (optionalPost.isPresent()){
            Posts newPost = optionalPost.get();
            newPost.setMessageText(post.getMessageText());
            return postsRepository.save(newPost);
        }
        else{
            return null;
        }
    }

    public Posts updatePostLikes(int PostId, Posts post){
        Optional<Posts> optionalPost = postsRepository.findById(PostId);
        if (optionalPost.isPresent()){
            Posts newPost = optionalPost.get();
            newPost.setPostLikes(post.getPostLikes());
            return postsRepository.save(newPost);
        }
        else{
            return null;
        }
    }

    public List<Posts> getPostsByAccount(int AccountId){
        return postsRepository.findByAccountId(AccountId);
    }

}
