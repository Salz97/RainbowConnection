package com.rainbowconnection.rainbowconnection.Users;

import com.rainbowconnection.rainbowconnection.followers.FollowerRepository;
import com.rainbowconnection.rainbowconnection.followers.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private FollowerRepository followerRepository;
//    private Followers followers;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
//        this.followers = followers;
    }
// this allows random users to pupulate the database based on the usercount number.
// I have considered for usercount range to be between 1 and 100000 and thrown an error if the number is out of this range.
    //This connects to a Post mapping(/testdata)
    @Transactional
    public void addRandomUsers(int userCount) {
        String[] firstNames = {"Lilly", "James", "Carson", "Daisy", "Albert", "Thomas", "Bill", "Anna", "Preeti"};
        String[] lastNames = {"Marge", "Smith", "Baker", "Thornton", "Anderson", "McGuire"};
        String[] colours = {"orange", "green", "yellow", "purple", "red", "blue", "white", "black", "pink", "brown"};
        Random randomFirstName = new Random();
        Random randomLastName = new Random();
        Random randomColour = new Random();


        usersRepository.deleteAll();
        if (userCount < 1 || userCount > 100000) {
            throw new IllegalStateException("usercount cannot be this number");
        } else {
            for (int i = 0; i < userCount; i++) {
                Users newPerson = new Users();
                newPerson.setFollowerCount((int) (Math.random() * 50));
                newPerson.setFirstName(firstNames[randomFirstName.nextInt(9)]);
                newPerson.setLastName(lastNames[randomLastName.nextInt(6)]);
                newPerson.setColour(colours[randomColour.nextInt(10)]);
                usersRepository.save(newPerson);
            }
        }
    }
 // this retrieves all user information from their id.
    @Transactional
    public Users getUsersById(int id) {
        // I added

        return usersRepository.findbyId(id);
    }

    @Transactional
    public List<Users> allUsers() {
        return usersRepository.findAll();
    }
  // this is meant to add followers to users,however it is has some errors.
    @Transactional
    public Users addFollowers(int userId, int followerId) {
        Users user = usersRepository.findbyId(userId);
        Users follower = usersRepository.findbyId(followerId);

            Followers follow = new Followers();
            follow.setId(follower.getId());
            follow.setFirstName(follower.getFirstName());
            follow.setLastName(follower.getLastName());
            List<Followers> following = new ArrayList<>();
            following.add(follow);
            user.setFollowers(following);


            return user;
        }
    }

