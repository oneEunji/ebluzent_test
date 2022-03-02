package com.jojoldu.book.springboot.domain.users;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u ORDER BY u.userNoId DESC")
    List<Users> findAllDesc();

//    Optional<Users> findByEmail(String userEmail);
}
