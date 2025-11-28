package com.example.BlogApplication.Repositories;

import com.example.BlogApplication.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositorie extends JpaRepository<Post,Integer> {

}
