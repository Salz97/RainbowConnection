package com.rainbowconnection.rainbowconnection.followers;

import com.rainbowconnection.rainbowconnection.Users.Users;

import javax.persistence.*;
import java.util.Set;

@Entity(name="followers")
@Table(name="Followers")
public class Followers {
    @Id
    @SequenceGenerator(
            name= "followers_sequence",
            sequenceName = "followers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "followers_sequence"
    )
    @Column(
            name = "follower_id",
            updatable = false
    )
    private int id;
   @ManyToMany(mappedBy = "followers")
    private Set<Users>users;

    private String firstName;
    private String lastName;

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
}
