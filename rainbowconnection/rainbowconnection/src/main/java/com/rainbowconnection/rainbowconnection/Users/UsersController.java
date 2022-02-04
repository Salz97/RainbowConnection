package com.rainbowconnection.rainbowconnection.Users;

import com.rainbowconnection.rainbowconnection.followers.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UsersController {
    private UsersService userService;


    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/testdata")
    public void addRandomUsers(@RequestParam int usercount){
        userService.addRandomUsers(usercount);
    }
    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable("id") int id){
        return userService.getUsersById(id);
    }
    @GetMapping("/users")
    public List<Users>findAll(){
        return userService.allUsers();
    }
    @PostMapping("/followers/{id}/{followerID}")
    public Users add(@PathVariable("id") int id,@PathVariable("followerID") int followerID){
        return userService.addFollowers(id,followerID);
    }
}
