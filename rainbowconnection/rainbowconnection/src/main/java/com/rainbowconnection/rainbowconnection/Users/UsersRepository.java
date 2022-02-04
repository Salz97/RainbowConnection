package com.rainbowconnection.rainbowconnection.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;

public interface UsersRepository extends JpaRepository<Users,String> {
    @Query(value="SELECT * FROM users WHERE user_id=:id",nativeQuery = true)
     Users findbyId(@PathVariable("id")int id);
}
