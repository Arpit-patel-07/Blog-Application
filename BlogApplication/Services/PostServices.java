package com.example.BlogApplication.Services;

import com.example.BlogApplication.Converters.PostConverter;
import com.example.BlogApplication.Dtos.PostRequest;
import com.example.BlogApplication.Dtos.PostResponse;
import com.example.BlogApplication.Entities.Category;
import com.example.BlogApplication.Entities.Post;
import com.example.BlogApplication.Entities.User;
import com.example.BlogApplication.Exception.ResourceNotFoundException;
import com.example.BlogApplication.Repositories.CategoryRepositorie;
import com.example.BlogApplication.Repositories.PostRepositorie;
import com.example.BlogApplication.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

        @Autowired
        private PostRepositorie postRepositorie;

        @Autowired
        private UserRepositorie userRepositorie;

        @Autowired
        private CategoryRepositorie categoryRepositorie;


        public PostResponse createPost(PostRequest postRequest, int categoryId, int userId){

                Optional<Category> existCategory =  categoryRepositorie.findById(categoryId);
                Optional<User> existUser = userRepositorie.findById(userId);

                if(existCategory.isEmpty() || existUser.isEmpty()){
                    throw new ResourceNotFoundException("Resource Not Found");
                }
                Category category = existCategory.get();
                User user = existUser.get();
                Post post = PostConverter.postRequestTopost(postRequest);
                post.setPostImage("default.img");
                post.setUser(user);
                post.setCategory(category);
                Post savePost = postRepositorie.save(post);
                return PostConverter.postToPostResponse(savePost);
        }


        public PostResponse updatePost(PostRequest postRequest,int postId){

            Optional<Post> existPost = postRepositorie.findById(postId);

            if(existPost.isEmpty()){
                throw new ResourceNotFoundException("Resource Not Found");
            }

            Post post = existPost.get();
            post.setPostTitle(postRequest.getPostTitle());
            post.setPostContent(postRequest.getPostContent());

            Post savePost = postRepositorie.save(post);
            return PostConverter.postToPostResponse(savePost);
        }

        public void deletePost(int postId){

            Optional<Post> existPost = postRepositorie.findById(postId);

            if(existPost.isEmpty()){
                throw new ResourceNotFoundException("Resource Not Found");
            }
            Post post = existPost.get();
            postRepositorie.delete(post);
        }

        public List<PostResponse> gelAllPost(int pageNumber, int pageSize,String sortBy){

            Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).descending());

            Page<Post> pagePost = postRepositorie.findAll(pageable);

            List<Post> listOFPosts = pagePost.getContent();

            List<PostResponse> listOfPostResponse = new ArrayList<>();

            for(Post post : listOFPosts){
                PostResponse postResponse = PostConverter.postToPostResponse(post);
                listOfPostResponse.add(postResponse);
            }

            return listOfPostResponse;

        }

        // we need to return all these things
        //1.pageNumber 2.pageSize 3.
//
//        public PostResponse getPostById(int postId){
//

//        }
//
//        public  List<PostResponse> getPostsByCategory(int categoryId){
//
//        }
//
//        public List<PostResponse> getPostsByUserId(int userId){
//
//        }
//
//        public List<Post> searchPosts(String keyword){
//
//        }
}
