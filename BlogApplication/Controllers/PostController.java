package com.example.BlogApplication.Controllers;

import com.example.BlogApplication.Dtos.PostRequest;
import com.example.BlogApplication.Dtos.PostResponse;
import com.example.BlogApplication.Entities.Post;
import com.example.BlogApplication.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/Post")
public class PostController {

        @Autowired
        private PostServices postServices;

        @PostMapping("/create")
        public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest,@RequestParam("categoryId") int categoryId, @RequestParam("userId") int userId){
            PostResponse postResponse =  postServices.createPost(postRequest,categoryId,userId);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<PostResponse> updatePost( @RequestBody  PostRequest postRequest,@RequestParam("postId") int postId){
            PostResponse postResponse =  postServices.updatePost(postRequest,postId);
            return new ResponseEntity<>(postResponse, HttpStatus.OK);
        }

        @DeleteMapping("/delete")
        public ResponseEntity<?> deletePost(@RequestParam("postId") int postId){
            postServices.deletePost(postId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping("/get")
        public ResponseEntity<List<PostResponse>> getAllPost(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("sortBy") String sortBy){
            List<PostResponse> listOfPosResponse = postServices.gelAllPost(pageNumber,pageSize,sortBy);
            return new ResponseEntity<>(listOfPosResponse,HttpStatus.OK);
        }
//
//        public PostResponse getPostById(int postId){
//
//        }
//
//        public  List<PostResponse> getPostsByCategory(int categoryId){
//
//        }
//
//        public List<PostResponse> getPostsByUser(int userId){
//
//        }
//
//        public List<Post> searchPosts(String keyword){
//
//        }
}
