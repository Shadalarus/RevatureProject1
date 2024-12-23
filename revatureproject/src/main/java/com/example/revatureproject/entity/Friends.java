package com.example.revatureproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "friends")
public class Friends {
    @Column(name="friend_id")
    @Id
    @GeneratedValue
    private Integer friendId;

    @Column(name="sent_by")
    private Integer sentBy;

    @Column(name="received_by")
    private Integer receivedBy;

    @Column(name="accepted")
    private Integer accepted;

    public Friends(){

    }

    public Friends(Integer SentBy, Integer ReceivedBy){
        this.sentBy = SentBy;
        this.receivedBy = ReceivedBy;
    }

    public Friends(Integer FriendId, Integer SentBy, Integer ReceivedBy, Integer Accepted){
        this.friendId = FriendId;
        this.sentBy = SentBy;
        this.receivedBy = ReceivedBy;
        this.accepted = Accepted;
    }

    public Integer getFriendId(){
        return friendId;
    }
    public void setFriendId(Integer FriendId){
        this.friendId = FriendId;
    }

    public Integer getSentBy(){
        return sentBy;
    }
    public void setSentBy(Integer SentBy){
        this.sentBy = SentBy;
    }

    public Integer getReceivedBy(){
        return receivedBy;
    }
    public void setReceivedBy(Integer ReceivedBy){
        this.receivedBy = ReceivedBy;
    }

    public Integer getAccepted(){
        return accepted;
    }
    public void setAccepted(Integer Accepted){
        this.accepted = Accepted;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Friends other = (Friends) obj;
        if (sentBy == null) {
            if (other.sentBy != null)
                return false;
        } else if (!sentBy.equals(other.sentBy))
            return false;

        if (receivedBy == null) {
            if (other.receivedBy != null)
                return false;
        } else if (!receivedBy.equals(other.receivedBy))
            return false;
        
        if (accepted == null) {
            if (other.accepted != null)
                return false;
        } else if (!accepted.equals(other.accepted))
            return false;

        if (friendId == null) {
            if (other.friendId != null)
                return false;
        } else if (!friendId.equals(other.friendId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Post{" +
                "FriendId=" + friendId +
                ", SentBy='" + sentBy + '\'' +
                ", ReceivedBy='" + receivedBy + '\'' +
                ", Accepted='" + accepted + '\'' +
                '}';
    }
}
