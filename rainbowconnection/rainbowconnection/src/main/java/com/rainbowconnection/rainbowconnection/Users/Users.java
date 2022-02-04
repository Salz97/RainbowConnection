package com.rainbowconnection.rainbowconnection.Users;

import com.rainbowconnection.rainbowconnection.followers.Followers;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.*;



@Entity(name="Users")
@Table(name="users")
public class Users {
    @Id
    @SequenceGenerator(
            name= "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private int id;
    @Column(
            name="firstname",
            updatable = false
    )
    private String firstName;
    @Column(
            name="lastname",
            updatable = false
    )
    private String lastName;
    @Column(
            name="colour"

    )
    private String colour;
    @Column(
            name ="follower_count"
    )
    private int followerCount;
    @NonNull
    @ManyToMany(cascade =CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name= "users_followers",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "follower"))
    private List<Followers>followers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @NonNull
    public List<Followers> getFollowers() {
        return followers;
    }

    public void setFollowers(@NonNull List<Followers> followers) {
        this.followers = followers;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }
}
