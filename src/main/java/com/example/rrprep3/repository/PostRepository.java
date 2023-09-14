package com.example.rrprep3.repository;

import com.example.rrprep3.model.entity.Post;
import com.example.rrprep3.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

   List<Post> findAllByUser_Username(String username);

   @Query("select p from Post p where p.user.username <> :username ")
   List<Post> findAllByUserNameIsNot(@Param("username") String username);
}
