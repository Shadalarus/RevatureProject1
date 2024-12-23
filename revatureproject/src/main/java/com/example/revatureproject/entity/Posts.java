package com.example.revatureproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Posts {
    @Column(name="post_id")
    @Id
    @GeneratedValue
    private Integer postId;

    @Column(name="message_text")
    private String messageText;

    @Column(name="post_likes")
    private Integer postLikes;

    @Column(name="account_id")
    private Integer accountId;

    public Posts(){

    }

    public Posts(String messageText, Integer accountId){
        this.messageText = messageText;
        this.accountId = accountId;
    }

    public Posts(Integer postId, String messageText, Integer postLikes, Integer accountId){
        this.postId = postId;
        this.messageText = messageText;
        this.postLikes = postLikes;
        this.accountId = accountId;
    }

    public Integer getPostId(){
        return postId;
    }
    public void setPostId(Integer postId){
        this.postId = postId;
    }

    public Integer getAccountId(){
        return accountId;
    }
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }

    public String getMessageText(){
        return messageText;
    }
    public void setMessageText(String messageText){
        this.messageText = messageText;
    }

    public Integer getPostLikes(){
        return postLikes;
    }
    public void setPostLikes(Integer postLikes){
        this.postLikes = postLikes;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Posts other = (Posts) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;

        if (messageText == null) {
            if (other.messageText != null)
                return false;
        } else if (!messageText.equals(other.messageText))
            return false;
        
        if (postLikes == null) {
            if (other.postLikes != null)
                return false;
        } else if (!postLikes.equals(other.postLikes))
            return false;

        if (postId == null) {
            if (other.postId != null)
                return false;
        } else if (!postId.equals(other.postId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Post{" +
                "PostId=" + postId +
                ", MessageText='" + messageText + '\'' +
                ", PostLikes='" + postLikes + '\'' +
                ", AccountId='" + accountId + '\'' +
                '}';
    }
}
