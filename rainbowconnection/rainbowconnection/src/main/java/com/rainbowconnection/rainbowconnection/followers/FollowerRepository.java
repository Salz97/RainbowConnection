package com.rainbowconnection.rainbowconnection.followers;

import com.rainbowconnection.rainbowconnection.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface FollowerRepository extends JpaRepository<Followers,Integer> {
    @Query(value="SELECT * FROM users WHERE user_id=:id",nativeQuery = true)
    Followers findbyId(@PathVariable("id")int id);
}
