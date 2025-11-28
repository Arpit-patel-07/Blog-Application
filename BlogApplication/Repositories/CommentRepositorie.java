package com.example.BlogApplication.Repositories;

import com.example.BlogApplication.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositorie extends JpaRepository<Comment,Integer> {

}
