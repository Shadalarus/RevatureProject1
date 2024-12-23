package com.example.revatureproject.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "followers")
public class Followers {
    @Column(name="follow_id")
    @Id
    @GeneratedValue
    private Integer followId;

    @Column(name="follower_id")
    private Integer followerId;

    @Column(name="followed_id")
    private Integer followedId;

    public Followers(){

    }

    public Followers(Integer FollowerId, Integer FollowedId){
        this.followerId = FollowerId;
        this.followedId = FollowedId;
    }

    public Followers(Integer FollowId, Integer FollowerId, Integer FollowedId){
        this.followId = FollowId;
        this.followerId = FollowerId;
        this.followedId = FollowedId;
    }

    public Integer getFollowId(){
        return followId;
    }
    public void setFollowId(Integer FollowId){
        this.followId = FollowId;
    }

    public Integer getFollowerId(){
        return followerId;
    }
    public void setFollowerId(Integer FollowerId){
        this.followerId = FollowerId;
    }

    public Integer getFollowedId(){
        return followedId;
    }
    public void setFollowedId(Integer FollowedId){
        this.followedId = FollowedId;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Followers other = (Followers) obj;
        if (followerId == null) {
            if (other.followerId != null)
                return false;
        } else if (!followerId.equals(other.followerId))
            return false;

        if (followedId == null) {
            if (other.followedId != null)
                return false;
        } else if (!followedId.equals(other.followedId))
            return false;
        
        if (followId == null) {
            if (other.followId != null)
                return false;
        } else if (!followId.equals(other.followId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Post{" +
                "FollowId=" + followId +
                ", FollowerId='" + followerId + '\'' +
                ", FollowedId='" + followedId + '\'' +
                '}';
    }
}

