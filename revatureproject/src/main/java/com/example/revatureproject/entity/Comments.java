package com.example.revatureproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comments {
    @Column(name="comment_id")
    @Id
    @GeneratedValue
    private Integer commentId;

    @Column(name="comment_text")
    private String commentText;

    @Column(name="comment_likes")
    private Integer commentLikes;

    @Column(name="account_id")
    private Integer accountId;

    @Column(name="post_id")
    private Integer postId;

    public Comments(){

    }

    public Comments(String CommentText, Integer AccountId, Integer PostId){
        this.commentText = CommentText;
        this.accountId = AccountId;
        this.postId = PostId;
    }

    public Comments(Integer CommentId, String CommentText, Integer CommentLikes, Integer AccountId, Integer PostId){
        this.commentId = CommentId;
        this.commentText = CommentText;
        this.commentLikes = CommentLikes;
        this.accountId = AccountId;
        this.postId = PostId;
    }

    public Integer getCommentId(){
        return commentId;
    }
    public void setCommentId(Integer CommentId){
        this.commentId = CommentId;
    }

    public Integer getPostId(){
        return postId;
    }
    public void setPostId(Integer PostId){
        this.postId = PostId;
    }

    public Integer getAccountId(){
        return accountId;
    }
    public void setAccountId(Integer AccountId){
        this.accountId = AccountId;
    }

    public String getCommentText(){
        return commentText;
    }
    public void setCommentText(String CommentText){
        this.commentText = CommentText;
    }

    public Integer getCommentLikes(){
        return commentLikes;
    }
    public void setCommentLikes(Integer CommentLikes){
        this.commentLikes = CommentLikes;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Comments other = (Comments) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;

        if (commentText == null) {
            if (other.commentText != null)
                return false;
        } else if (!commentText.equals(other.commentText))
            return false;
        
        if (commentId == null) {
            if (other.commentId != null)
                return false;
        } else if (!commentId.equals(other.commentId))
            return false;

        if (commentLikes == null) {
            if (other.commentLikes != null)
                return false;
        } else if (!commentLikes.equals(other.commentLikes))
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
        return "Comment{" +
                "CommentId=" + commentId +
                ", CommentText='" + commentText + '\'' +
                ", CommentLikes='" + commentLikes + '\'' +
                ", AccountId='" + accountId + '\'' +
                ", PostId='" + postId + '\'' +
                '}';
    }
}
